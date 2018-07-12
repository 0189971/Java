/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.Semaphore;

/**
 *
 * @author javis
 */
class Manejador extends Thread {
    
                protected Socket socket;
                protected PrintWriter pw;
                protected BufferedOutputStream bos;
                protected BufferedReader br;
                protected String FileName;
                String line;
                servidor cl;
                Semaphore r;

                public Manejador(Socket _socket, Semaphore sem){
                    this.socket = _socket;
                    this.r=sem;
                }

                public void run() {
                    try {
                        r.acquire();
                        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        bos = new BufferedOutputStream(socket.getOutputStream());
                        pw = new PrintWriter(new OutputStreamWriter(bos));
                        line = br.readLine();
                        System.out.println("la linea es: "+line);
                        if (line == null) {
                            pw.print("<html><head><title>Servidor WEB");
                            pw.print("</title><body bgcolor=\"#AACCFF\"<br>Linea Vacia</br>");
                            pw.print("</body></html>");
                            socket.close();
                            return;
                        }
                        System.out.println("\nCliente Conectado desde: " + socket.getInetAddress());
                        System.out.println("Por el puerto: " + socket.getPort());
                        System.out.println("Datos: " + line + "\r\n\r\n");

                        if (line.indexOf("?") == -1) {
                            getArch(line);
                            if (FileName.compareTo("") == 0) {
                                SendA("index.htm");
                            }else {
                                SendA(FileName);
                            }
                            System.out.println("El nombre del archivo es: "+FileName);

                        } else if (line.toUpperCase().startsWith("GET")) { //El metodo post
                            StringTokenizer tokens = new StringTokenizer(line, "?");
                            String req_a = tokens.nextToken();
                            String req = tokens.nextToken();
                            System.out.println("Token1: " + req_a + "\r\n\r\n");
                            System.out.println("Token2: " + req + "\r\n\r\n");
                            pw.println("HTTP/1.0 200 Okay");
                            pw.flush();
                            pw.println();
                            pw.flush();
                            pw.print("<html><head><title>SERVIDOR WEB");
                            pw.flush();
                            pw.print("</title></head><body bgcolor=\"#AACCFF\"><center><h1><br>Parametros Obtenidos..</br></h1>");
                            pw.flush();
                            pw.print("<h3><b>" + req + "</b></h3>");
                            pw.flush();
                            pw.print("</center></body></html>");
                            pw.flush();
                        } else if(line.toUpperCase().startsWith("POST")){
                            StringTokenizer tokens = new StringTokenizer(line, "?");
                            line=tokens.nextToken();
                            System.out.println("Linea con post es: "+line);
                            pw.println(line);
                            pw.println("HTTP/1.0 200 Ok");
                            pw.flush();
                            pw.println();
                            pw.flush();
                            pw.print("<html><head><title>SERVIDOR WEB");
                            pw.flush();
                            pw.print("</title></head><body bgcolor=\"#AACCFF\"><center><h1><br>Parametros Obtenidos..</br></h1>");
                            pw.flush();
                            pw.print("<h3><b>"+"</b></h3>");
                            pw.flush();
                            pw.print("</center></body></html>");
                            pw.flush();
                        }else if(line.toUpperCase().startsWith("HEAD")){
                            pw.println("HTTP/1.0 200 Ok");
                            pw.flush();
                            pw.println();
                        }
                        else {
                            pw.println("HTTP/1.0 501 Not Implemented");
                            pw.println();
                        }
                        pw.flush();
                        bos.flush();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally{
                        //r.release();
                    }
                }

                public void getArch(String line) {
                    int i;
                    int f;
                    if (line.toUpperCase().startsWith("GET") || line.toUpperCase().startsWith("POST") || line.toUpperCase().startsWith("HEAD")) {    //Para el metodo Post
                        i = line.indexOf("/");
                        f = line.indexOf(" ", i);
                        FileName = line.substring(i + 1, f);
                        System.out.println("la variable es: "+FileName);
                    }
                }

                public void SendA(String fileName, Socket sc) {
                    //System.out.println(fileName);
                    int fSize = 0;
                    byte[] buffer = new byte[4096];
                    try {
                        DataOutputStream out = new DataOutputStream(sc.getOutputStream());

                        //sendHeader();
                        FileInputStream f = new FileInputStream(fileName);
                        int x = 0;
                        while ((x = f.read(buffer)) > 0) {
                            //		System.out.println(x);
                            out.write(buffer, 0, x);
                        }
                        out.flush();
                        f.close();
                    } catch (FileNotFoundException e) {
                        //msg.printErr("Transaction::sendResponse():1", "El archivo no existe: " + fileName);
                    } catch (IOException e) {
                        //			System.out.println(e.getMessage());
                        //msg.printErr("Transaction::sendResponse():2", "Error en la lectura del archivo: " + fileName);
                    }

                }

                public void SendA(String arg) {
                    try {
                        int b_leidos = 0;
                        BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(arg));
                        byte[] buf = new byte[1024];
                        int tam_bloque = 0;
                        if (bis2.available() >= 1024) {
                            tam_bloque = 1024;
                        } else {
                            bis2.available();
                        }

                        int tam_archivo = bis2.available();
                        /**
                         * ********************************************
                         */

                        String sb = "";
                        sb = sb + "HTTP/1.0 200 ok\n";
                        sb = sb + "Server: Axel Server/1.0 \n";
                        sb = sb + "Date: " + new Date() + " \n";
                        sb = sb + "Content-Type: text/html \n";

                        if (arg.contains("pdf")) {  //tipo de datos entrantes 
                            sb = sb + "Content-Type: application/pdf \n";
                        }
                        else if(arg.contains("jpeg")||arg.contains("jpg")){
                            sb = sb + "Content-Type: image/jpeg \n";
                        }
                        else{
                            sb = sb + "Content-Type: text/html \n";
                        }
                        sb = sb + "Content-Length: " + tam_archivo + " \n";
                        sb = sb + "\n";
                        bos.write(sb.getBytes());
                        bos.flush();

                        //out.println("HTTP/1.0 200 ok");
                        //out.println("Server: Axel Server/1.0");
                        //out.println("Date: " + new Date());
                        //out.println("Content-Type: text/html");
                        //out.println("Content-Length: " + mifichero.length());
                        //out.println("\n");
                        /**
                         * ********************************************
                         */
                        while ((b_leidos = bis2.read(buf, 0, buf.length)) != -1) {
                            bos.write(buf, 0, b_leidos);

                        }
                        bos.flush();
                        bis2.close();

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            }
        