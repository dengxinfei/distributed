package com.distributed.zk.rpcServer;

import com.distributed.zk.IHandle;
import com.distributed.zk.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个RPC的Server
 *
 * Created by xinfei on 2018/6/12.
 */
public class RPCServer1 {

    private static final ExecutorService excutorService = Executors.newFixedThreadPool(10);

    private final static String serviceUrl = "127.0.0.1:8080";

    private final static String serviceName = "ZKServer1";



    public static void main(String[] args) {
        IHandle handle = new HandleImpl();

        //注册服务
        RegisterCenter.register(serviceName, serviceUrl);

        //绑定端口，启动Socket
        String[] addrs = serviceUrl.split(":");
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(Integer.parseInt(addrs[1]));

            while (1 == 1){
                Socket socket= serverSocket.accept();
                System.out.println("RPCServer1---服务端收到请求......");
                excutorService.execute(new Handle(socket));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    static class Handle implements Runnable{
        private Socket socket;

        public Handle(Socket socket){
            this.socket = socket;
        }

        public void run() {
            //处理请求
            ObjectInputStream inputStream=null;
            try {
                //获取客户端的输入流
                inputStream=new ObjectInputStream(socket.getInputStream());
                //反序列化远程传输的对象RpcRequest
                RpcRequest request=(RpcRequest) inputStream.readObject();
                System.out.println("RPCServer1---线程：" + Thread.currentThread().getName() + "开始处理请求，参数=" + request.toString());
                Object result=invoke(request); //通过反射去调用本地的方法

                //通过输出流讲结果输出给客户端
                ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(result);
                outputStream.flush();
                inputStream.close();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(inputStream!=null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private Object invoke(RpcRequest request) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            //以下均为反射操作，目的是通过反射调用服务
            Object[] args=request.getParameters();
            Class<?>[] types=new Class[args.length];
            for(int i=0;i<args.length;i++){
                types[i]=args[i].getClass();
            }
            String serviceName=request.getClassName();

            //从handlerMap中，根据客户端请求的地址，去拿到响应的服务，通过反射发起调用
            HashMap<String, Object> handlerMap = new HashMap<String, Object>();
            handlerMap.put(IHandle.class.getName(), new HandleImpl());
            Object service = handlerMap.get(serviceName);
            Method method = service.getClass().getMethod(request.getMethodName(),types);
            return method.invoke(service,args);
        }

    }



}
