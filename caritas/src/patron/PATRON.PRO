(UMLStudio "6.0" project)
(repository "" 0)
(notation "UML.not")
(genProfile 178 4 "" "" 0 "" "" 700 360 217 272 50 50 80 50 80 60 0 0)
(codeFiles)
(docFiles)
(otherFiles)
(revFiles 4 "C:\seminario\codigo\und09\patron\FlujoAleatorio.java" 
          "C:\seminario\codigo\und09\patron\FlujoBufferedInputStream.java" 
          "C:\seminario\codigo\und09\patron\FlujoBufferedOutputStream.java" 
          "C:\seminario\codigo\und09\patron\FlujoFileReader.java" 
          "C:\seminario\codigo\und09\patron\FlujoFileWriter.java" 
          "C:\seminario\codigo\und09\patron\FlujoRandomAccessFile.java" 
          "C:\seminario\codigo\und09\patron\FlujosDeEntrada.java" 
          "C:\seminario\codigo\und09\patron\FlujosDeEntradaTexto.java" 
          "C:\seminario\codigo\und09\patron\FlujosDeSalida.java" 
          "C:\seminario\codigo\und09\patron\FlujosDeSalidaTexto.java" 
          "C:\seminario\codigo\und09\patron\FlujosFactory.java" 
          "C:\seminario\codigo\und09\patron\IFlujosFactory.java" 
          "C:\seminario\codigo\und09\patron\PruebaFlujos.java" 
          "C:\seminario\codigo\und09\patron\PruebaFlujos1.java" 
          "C:\seminario\codigo\und09\patron\PruebaFlujos2.java")
(masters (master "p&!$zJP-!n|q@!!" 1 3 "FlujosDeSalidaTexto" "" "" "" "" "" 5 
                 (("nombreArchivo" "String" "" "" "" "" 1 16 
                                   "r&!$zJP-!n|q@!!")) 
                 (("getNombreArchivo" "String" "" 3 16 nil nil 
                                      "s&!$zJP-!n|q@!!" 
                                      "^t{^r^n^t^treturn nombreArchivo;^r^n^t}") 
                  ("setNombreArchivo" "void" "" 3 16 
                                      (("otroArchivo" "String" "" 0)) nil 
                                      "t&!$zJP-!n|q@!!" 
                                      "^t{^r^n^t^tnombreArchivo = otroArchivo;^r^n^t}") 
                  ("getFlujoTexto" "FileWriter" "" 3 144 
                                   (("archivo" "String" "" 0)) nil 
                                   "u&!$zJP-!n|q@!!" "")) nil nil 10 "") 
         (master "d&!$zJP-!n|q@!!" 1 3 "FlujosDeEntrada" "" "" "" "" "" 5 
                 (("dIn" "DataInputStream" "" "" "" "" 1 16 "f&!$zJP-!n|q@!!") 
                  ("nombreArchivo" "String" "" "" "" "" 1 16 "g&!$zJP-!n|q@!!") 
                  ("fInStr" "FileInputStream" "" "" "" "" 1 16 
                            "h&!$zJP-!n|q@!!")) 
                 (("getFlujoArchivo" "FileInputStream" "" 0 16 nil 
                                     (("FileNotFoundException" 0)) 
                                     "i&!$zJP-!n|q@!!" 
                                     "^t{^r^n^t^tfInStr = new FileInputStream( nombreArchivo );^r^n^t^treturn fInStr;^r^n^t}") 
                  ("getNombreArchivo" "String" "" 0 16 nil nil 
                                      "j&!$zJP-!n|q@!!" 
                                      "^t{^r^n^t^treturn nombreArchivo;^r^n^t}") 
                  ("getDataInputStream" "DataInputStream" "" 0 16 nil 
                                        (("FileNotFoundException" 0)) 
                                        "k&!$zJP-!n|q@!!" 
                                        "^t{^r^n^t^tfInStr = new FileInputStream( nombreArchivo );^r^n^t^tdIn = new DataInputStream( fInStr );^r^n^t^treturn dIn;^r^n^t}") 
                  ("setNombreArchivo" "void" "" 0 16 
                                      (("nombreAr" "String" "" 0)) nil 
                                      "l&!$zJP-!n|q@!!" 
                                      "^t{^r^n^t^tnombreArchivo = nombreAr;^r^n^t}") 
                  ("setFileInputStream" "void" "" 0 16 
                                        (("otroFile" "FileInputStream" "" 0)) 
                                        nil "m&!$zJP-!n|q@!!" 
                                        "^t{^r^n^t^tfInStr = otroFile;^r^n^t}") 
                  ("setDataInputStream" "void" "" 0 16 
                                        (("otroDOut" "DataInputStream" "" 0)) 
                                        nil "n&!$zJP-!n|q@!!" 
                                        "^t{^r^n^t^tdIn = otroDOut;^r^n^t}") 
                  ("getFlujo" "DataInputStream" "" 3 144 
                              (("nombreArchivo" "String" "" 0)) nil 
                              "o&!$zJP-!n|q@!!" "")) nil nil 10 "") 
         (master "]&!$zJP-!n|q@!!" 1 3 "IFlujosFactory" "" "" "" "" "" 7 nil 
                 (("creaFlujoDeSalida" "FlujosDeSalida" "" 3 144 nil nil 
                                       "_&!$zJP-!n|q@!!" "") 
                  ("creaFlujoDeEntrada" "FlujosDeEntrada" "" 3 144 nil nil 
                                        "`&!$zJP-!n|q@!!" "") 
                  ("creaFlujoDeSalidaTexto" "FlujosDeSalidaTexto" "" 3 144 nil 
                                            nil "a&!$zJP-!n|q@!!" "") 
                  ("creaFlujoDeEntradaTexto" "FlujosDeEntradaTexto" "" 3 144 
                                             nil nil "b&!$zJP-!n|q@!!" "") 
                  ("creaFlujoAleatorio" "FlujoAleatorio" "" 3 144 nil nil 
                                        "c&!$zJP-!n|q@!!" "")) nil nil 10 "") 
         (master "Z&!$zJP-!n|q@!!" 1 3 "FlujoRandomAccessFile" "" "" "" "" "" 
                 1 nil 
                 (("getFlujoAleatorio" "RandomAccessFile" "" 3 16 
                                       (("archivo" "String" "" 0) 
                                        ("mod" "String" "" 0)) nil 
                                       "\&!$zJP-!n|q@!!" 
                                       "^t{^r^n^t^tsetNombreYModo( archivo, mod );^r^n^t^tRandomAccessFile flujo = null;^r^n^t^ttry {^r^n^t^t^tflujo = new RandomAccessFile( getNombreArchivo(), getModo() );^r^n^t^t} catch( FileNotFoundException error ) {^r^n^t^t^terror.printStackTrace();^r^n^t^t^t}^r^n^t^treturn flujo;^r^n^t}")) 
                 nil nil 10 "") 
         (master "N&!$zJP-!n|q@!!" 1 3 "FlujoBufferedOutputStream" "" "" "" "" 
                 "" 1 nil 
                 (("getFlujo" "DataOutputStream" "" 3 16 
                              (("nombreArchivo" "String" "" 0)) nil 
                              "P&!$zJP-!n|q@!!" 
                              "^t{^r^n^t^tBufferedOutputStream elFlujo = null;^r^n^t^ttry {^r^n^t^t^tsetNombreArchivo( nombreArchivo );^r^n^t^t^telFlujo = new BufferedOutputStream( getFlujoArchivo() );^r^n^t^t} catch( FileNotFoundException error ) {^r^n^t^t^terror.printStackTrace();^r^n^t^t^t}^r^n^t^treturn new DataOutputStream( elFlujo );^r^n^t}")) 
                 nil nil 10 "") 
         (master "F&!$zJP-!n|q@!!" 1 3 "FlujoAleatorio" "" "" "" "" "" 5 
                 (("nombreArchivo" "String" "" "" "" "" 1 16 "H&!$zJP-!n|q@!!") 
                  ("modo" "String" "" "" "" "" 1 16 "I&!$zJP-!n|q@!!")) 
                 (("getNombreArchivo" "String" "" 3 16 nil nil 
                                      "J&!$zJP-!n|q@!!" 
                                      "^t{^r^n^t^treturn nombreArchivo;^r^n^t}") 
                  ("getModo" "String" "" 3 16 nil nil "K&!$zJP-!n|q@!!" 
                             "^t{^r^n^t^treturn modo;^r^n^t}") 
                  ("setNombreYModo" "void" "" 3 16 
                                    (("archivo" "String" "" 0) 
                                     ("mod" "String" "" 0)) nil 
                                    "L&!$zJP-!n|q@!!" 
                                    "^t{^r^n^t^tnombreArchivo = archivo;^r^n^t^tmodo = mod;^r^n^t}") 
                  ("getFlujoAleatorio" "RandomAccessFile" "" 3 144 
                                       (("archivo" "String" "" 0) 
                                        ("mod" "String" "" 0)) nil 
                                       "M&!$zJP-!n|q@!!" "")) nil nil 10 "") 
         (master "C&!$zJP-!n|q@!!" 1 3 "FlujoBufferedInputStream" "" "" "" "" 
                 "" 1 nil 
                 (("getFlujo" "DataInputStream" "" 3 16 
                              (("nombreArchivo" "String" "" 0)) nil 
                              "E&!$zJP-!n|q@!!" 
                              "^t{^r^n^t^tBufferedInputStream elFlujo = null;^r^n^t^ttry {^r^n^t^t^tsetNombreArchivo( nombreArchivo );^r^n^t^t^telFlujo = new BufferedInputStream( getFlujoArchivo() );^r^n^t^t} catch( FileNotFoundException error ) {^r^n^t^t^terror.printStackTrace();^r^n^t^t^t}^r^n^t^treturn new DataInputStream( elFlujo );^r^n^t}")) 
                 nil nil 10 "") 
         (master "@&!$zJP-!n|q@!!" 1 3 "FlujoFileWriter" "" "" "" "" "" 1 nil 
                 (("getFlujoTexto" "FileWriter" "" 3 16 
                                   (("archivo" "String" "" 0)) nil 
                                   "B&!$zJP-!n|q@!!" 
                                   "^t{^r^n^t^tsetNombreArchivo( archivo );^r^n^t^tFileWriter escritor = null;^r^n^t^ttry {^r^n^t^t^tescritor = new FileWriter( getNombreArchivo() );^r^n^t^t} catch( IOException error ) {^r^n^t^t^terror.printStackTrace();^r^n^t^t}^r^n^t^treturn escritor;^r^n^t}")) 
                 nil nil 10 "") 
         (master "=&!$zJP-!n|q@!!" 1 4 "PruebaFlujos" "" "" "" "" "" 1 nil 
                 (("main" "void" "" 3 17 (("args" "String[]" "" 0)) nil 
                          "?&!$zJP-!n|q@!!" 
                          "^t{^r^n^t^tFlujosFactory flujoFac = new FlujosFactory();^r^n^t^tFlujosDeEntrada fdin = flujoFac.creaFlujoDeEntrada();^r^n^t^tDataInputStream din = fdin.getFlujo( ^"c:\\scandisk.log^" );^r^n^t^tFlujosDeSalida fdout = flujoFac.creaFlujoDeSalida();^r^n^t^tDataOutputStream dout = fdout.getFlujo( ^"c:\\scandisk.cpy^" );^r^n^t^ttry {^r^n^t^t^tString linea = din.readLine();^r^n^t^t^tSystem.out.println( linea );^r^n^t^t^twhile( linea!=null ) {^r^n^t^t^t^tif( linea!=null ) {^r^n^t^t^t^t^tSystem.out.println( linea );^r^n^t^t^t^t^tdout.writeBytes( linea );^r^n^t^t^t^t^tdout.writeByte( '\n' );^r^n^t^t^t^t^t}^r^n^t^t^t^tlinea = din.readLine();^r^n^t^t^t^t}^r^n^t^t^tdin.close();^r^n^t^t^tdout.close();^r^n^t^t} catch( EOFException error ) {^r^n^t^t^terror.printStackTrace();^r^n^t^t} catch( IOException error ) {^r^n^t^t^terror.printStackTrace();^r^n^t^t}^r^n^t}")) 
                 nil nil 10 "") 
         (master "6&!$zJP-!n|q@!!" 1 3 "FlujosFactory" "" "" "" "" "" 1 nil 
                 (("creaFlujoDeEntrada" "FlujosDeEntrada" "" 3 16 nil nil 
                                        "8&!$zJP-!n|q@!!" 
                                        "^t{^r^n^t^treturn new FlujoBufferedInputStream();^r^n^t}") 
                  ("creaFlujoDeSalida" "FlujosDeSalida" "" 3 16 nil nil 
                                       "9&!$zJP-!n|q@!!" 
                                       "^t{^r^n^t^treturn new FlujoBufferedOutputStream();^r^n^t}") 
                  ("creaFlujoDeSalidaTexto" "FlujosDeSalidaTexto" "" 3 16 nil 
                                            nil ":&!$zJP-!n|q@!!" 
                                            "^t{^r^n^t^treturn new FlujoFileWriter();^r^n^t}") 
                  ("creaFlujoDeEntradaTexto" "FlujosDeEntradaTexto" "" 3 16 
                                             nil nil ";&!$zJP-!n|q@!!" 
                                             "^t{^r^n^t^treturn new FlujoFileReader();^r^n^t}") 
                  ("creaFlujoAleatorio" "FlujoAleatorio" "" 3 16 nil nil 
                                        "<&!$zJP-!n|q@!!" 
                                        "^t{^r^n^t^treturn new FlujoRandomAccessFile();^r^n^t}")) 
                 nil nil 10 "") 
         (master "*&!$zJP-!n|q@!!" 1 3 "FlujosDeSalida" "" "" "" "" "" 5 
                 (("dOut" "DataOutputStream" "" "" "" "" 1 16 
                          ",&!$zJP-!n|q@!!") 
                  ("nombreArchivo" "String" "" "" "" "" 1 16 "-&!$zJP-!n|q@!!") 
                  ("fOutStr" "FileOutputStream" "" "" "" "" 1 16 
                             ".&!$zJP-!n|q@!!")) 
                 (("getFlujoArchivo" "FileOutputStream" "" 0 16 nil 
                                     (("FileNotFoundException" 0)) 
                                     "/&!$zJP-!n|q@!!" 
                                     "^t{^r^n^t^tfOutStr = new FileOutputStream( nombreArchivo );^r^n^t^treturn fOutStr;^r^n^t}") 
                  ("getNombreArchivo" "String" "" 0 16 nil nil 
                                      "0&!$zJP-!n|q@!!" 
                                      "^t{^r^n^t^treturn nombreArchivo;^r^n^t}") 
                  ("getDataInputStream" "DataOutputStream" "" 0 16 nil 
                                        (("FileNotFoundException" 0)) 
                                        "1&!$zJP-!n|q@!!" 
                                        "^t{^r^n^t^tfOutStr = new FileOutputStream( nombreArchivo );^r^n^t^tdOut = new DataOutputStream( fOutStr );^r^n^t^treturn dOut;^r^n^t}") 
                  ("setNombreArchivo" "void" "" 0 16 
                                      (("nombreAr" "String" "" 0)) nil 
                                      "2&!$zJP-!n|q@!!" 
                                      "^t{^r^n^t^tnombreArchivo = nombreAr;^r^n^t}") 
                  ("setFile" "void" "" 0 16 
                             (("otroFile" "FileOutputStream" "" 0)) nil 
                             "3&!$zJP-!n|q@!!" 
                             "^t{^r^n^t^tfOutStr = otroFile;^r^n^t}") 
                  ("setDataOutputStream" "void" "" 0 16 
                                         (("otroDOut" "DataOutputStream" "" 0)) 
                                         nil "4&!$zJP-!n|q@!!" 
                                         "^t{^r^n^t^tdOut = otroDOut;^r^n^t}") 
                  ("getFlujo" "DataOutputStream" "" 3 144 
                              (("nombreArchivo" "String" "" 0)) nil 
                              "5&!$zJP-!n|q@!!" "")) nil nil 10 "") 
         (master "'&!$zJP-!n|q@!!" 1 3 "PruebaFlujos2" "" "" "" "" "" 1 nil 
                 (("main" "void" "" 3 17 (("args" "String[]" "" 0)) nil 
                          ")&!$zJP-!n|q@!!" 
                          "^t{^r^n^t^tFlujosFactory ff = new FlujosFactory();^r^n^t^tFlujoAleatorio fa = ff.creaFlujoAleatorio();^r^n^t^tRandomAccessFile rafin = fa.getFlujoAleatorio( ^"c:\\autoexec.bak^", ^"r^" );^r^n^t^tRandomAccessFile rafout = fa.getFlujoAleatorio( ^"c:\\autoexec.bbb^", ^"rw^" );^r^n^t^ttry {^r^n^t^t^tString linea = rafin.readLine();^r^n^t^t^twhile( linea!=null ) {^r^n^t^t^t^tif( linea!=null ) {^r^n^t^t^t^t^tSystem.out.println( linea );^r^n^t^t^t^t^trafout.writeBytes( linea );^r^n^t^t^t^t^trafout.writeByte( '\n' );^r^n^t^t^t^t^t}^r^n^t^t^t^tlinea = rafin.readLine();^r^n^t^t^t^t}^r^n^t^t^trafin.close();^r^n^t^t^trafout.close();^r^n^t^t} catch( IOException error ) {^r^n^t^t^terror.printStackTrace();^r^n^t^t^t}^r^n^t}")) 
                 nil nil 10 "") 
         (master "$&!$zJP-!n|q@!!" 1 3 "PruebaFlujos1" "" "" "" "" "" 1 nil 
                 (("main" "void" "" 3 17 (("args" "String[]" "" 0)) nil 
                          "&&!$zJP-!n|q@!!" 
                          "^t{^r^n^r^n^t^tFlujosFactory ff = new FlujosFactory();^r^n^t^tFlujosDeEntradaTexto fintxt = ff.creaFlujoDeEntradaTexto();^r^n^t^tFileReader fr = fintxt.getFlujoTexto( ^"c:\\autoexec.bak^" );^r^n^t^t^r^n^t^tFlujosDeSalidaTexto fouttxt = ff.creaFlujoDeSalidaTexto();^r^n^t^tFileWriter fw = fouttxt.getFlujoTexto( ^"c:\\autoexec.bbk^" );^r^n^t^ttry {^r^n^t^t^tint ica = fr.read();^r^n^t^t^twhile( ica!=-1 ) {^r^n^t^t^t^tif( ica!=-1 ) {^r^n^t^t^t^t^tSystem.out.print( (char)ica );^r^n^t^t^t^t^tfw.write( ica );^r^n^t^t^t^t^t}^r^n^t^t^t^tica = fr.read();^r^n^t^t^t^t}^r^n^t^t^tfr.close();^r^n^t^t^tfw.close();^r^n^t^t} catch( IOException error ) {^r^n^t^t^terror.printStackTrace();^r^n^t^t^t}^r^n^t}")) 
                 nil nil 10 "") 
         (master "Q&!$zJP-!n|q@!!" 1 3 "FlujosDeEntradaTexto" "" "" "" "" "" 5 
                 (("nombreArchivo" "String" "" "" "" "" 1 16 
                                   "S&!$zJP-!n|q@!!")) 
                 (("getNombreArchivo" "String" "" 3 16 nil nil 
                                      "T&!$zJP-!n|q@!!" 
                                      "^t{^r^n^t^treturn nombreArchivo;^r^n^t}") 
                  ("setNombreArchivo" "void" "" 3 16 
                                      (("otroArchivo" "String" "" 0)) nil 
                                      "U&!$zJP-!n|q@!!" 
                                      "^t{^r^n^t^tnombreArchivo = otroArchivo;^r^n^t}") 
                  ("getFlujoTexto" "FileReader" "" 3 144 
                                   (("archivo" "String" "" 0)) nil 
                                   "V&!$zJP-!n|q@!!" "")) nil nil 10 "") 
         (master "W&!$zJP-!n|q@!!" 1 3 "FlujoFileReader" "" "" "" "" "" 1 nil 
                 (("getFlujoTexto" "FileReader" "" 3 16 
                                   (("archivo" "String" "" 0)) nil 
                                   "Y&!$zJP-!n|q@!!" 
                                   "^t{^r^n^t^tsetNombreArchivo( archivo );^r^n^t^tFileReader lector = null;^r^n^t^ttry {^r^n^t^t^tlector = new FileReader( getNombreArchivo() );^r^n^t^t} catch( FileNotFoundException error ) {^r^n^t^t^terror.printStackTrace();^r^n^t^t}^r^n^t^treturn lector;^r^n^t}")) 
                 nil nil 10 ""))
(customModel "#&!9zJP-!n|q@!!" 0 3 "Untitled" "" "" 17 "" "" 1.000000 1.000000 
             (0 0 1654 2336) (0 0 1654 2336) 
             (place "$&!$zJP-!n|q@!!" (3) "" 10 "%&!$zJP-!n|q@!!" 
                    (24 88 156 134) (19 83 161 139) (25 89 155 133) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "'&!$zJP-!n|q@!!" (3) "" 10 "(&!$zJP-!n|q@!!" 
                    (24 156 156 202) (19 151 161 207) (25 157 155 201) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "*&!$zJP-!n|q@!!" (3) "" 10 "+&!$zJP-!n|q@!!" 
                    (436 24 728 198) (431 19 733 203) (440 27 724 195) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "6&!$zJP-!n|q@!!" (3) "" 10 "7&!$zJP-!n|q@!!" 
                    (504 532 766 634) (499 527 771 639) (507 534 763 632) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "=&!$zJP-!n|q@!!" (3) "" 10 ">&!$zJP-!n|q@!!" 
                    (24 20 156 66) (19 15 161 71) (25 21 155 65) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "@&!$zJP-!n|q@!!" (3) "" 10 "A&!$zJP-!n|q@!!" 
                    (1020 172 1232 218) (1015 167 1237 223) 
                    (1023 173 1229 217) 1 0 (nil 1 -12 32 18 12 18 18) "") 
             (place "C&!$zJP-!n|q@!!" (3) "" 10 "D&!$zJP-!n|q@!!" 
                    (40 692 296 738) (35 687 301 743) (43 693 293 737) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "F&!$zJP-!n|q@!!" (3) "" 10 "G&!$zJP-!n|q@!!" 
                    (20 240 354 356) (15 235 359 361) (24 242 350 353) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "N&!$zJP-!n|q@!!" (3) "" 10 "O&!$zJP-!n|q@!!" 
                    (448 228 714 274) (443 223 719 279) (451 229 711 273) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "Z&!$zJP-!n|q@!!" (3) "" 10 "[&!$zJP-!n|q@!!" 
                    (20 380 354 426) (15 375 359 431) (24 381 350 425) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "]&!$zJP-!n|q@!!" (3) "" 10 " &!$zJP-!n|q@!!" 
                    (504 348 766 450) (499 343 771 455) (507 350 763 448) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "d&!$zJP-!n|q@!!" (3) "" 10 "e&!$zJP-!n|q@!!" 
                    (32 484 304 658) (27 479 309 663) (35 487 301 655) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "p&!$zJP-!n|q@!!" (3) "" 10 "q&!$zJP-!n|q@!!" 
                    (1008 60 1242 146) (1003 55 1247 151) (1011 61 1239 145) 1 
                    0 (nil 1 -12 32 18 12 18 18) "") 
             (link "7&!$zJP-!n|q@!!" " &!$zJP-!n|q@!!" (635 531 635 449) 3 "" 
                   "" "%%" "%%" "" "" 1 0 (630 481 640 499) (631 523 631 523) 
                   (631 457 631 457) 101 101 "v&!$zJP-!n|q@!!" 
                   (630 481 640 499) (620 444 650 536) (630 481 640 499) 2 0 
                   (nil 1 -12 32 18 12 18 18) "") 
             (link "A&!$zJP-!n|q@!!" "q&!$zJP-!n|q@!!" (1125 171 1125 145) 3 
                   "" "" "%%" "%%" "" "" 1 0 (1121 150 1129 166) 
                   (1121 163 1121 163) (1121 153 1121 153) 0 0 
                   "w&!$zJP-!n|q@!!" (1120 149 1130 167) (1110 136 1140 180) 
                   (1120 149 1130 167) 2 0 (nil 1 -12 32 18 12 18 18) "") 
             (link "D&!$zJP-!n|q@!!" "e&!$zJP-!n|q@!!" (168 691 168 657) 3 "" 
                   "" "%%" "%%" "" "" 1 0 (164 666 172 682) (164 683 164 683) 
                   (164 665 164 665) 0 0 "x&!$zJP-!n|q@!!" (163 665 173 683) 
                   (153 652 183 696) (163 665 173 683) 2 0 
                   (nil 1 -12 32 18 12 18 18) "") 
             (link "O&!$zJP-!n|q@!!" "+&!$zJP-!n|q@!!" (581 227 581 197) 3 "" 
                   "" "%%" "%%" "" "" 1 0 (577 204 585 220) (577 219 577 219) 
                   (577 205 577 205) 0 0 "y&!$zJP-!n|q@!!" (576 203 586 221) 
                   (566 192 596 232) (576 203 586 221) 2 0 
                   (nil 1 -12 32 18 12 18 18) "") 
             (link "[&!$zJP-!n|q@!!" "G&!$zJP-!n|q@!!" (187 379 187 355) 3 "" 
                   "" "%%" "%%" "" "" 1 0 (183 359 191 375) (183 371 183 371) 
                   (183 363 183 363) 0 0 "{&!$zJP-!n|q@!!" (182 358 192 376) 
                   (172 344 202 390) (182 358 192 376) 2 0 
                   (nil 1 -12 32 18 12 18 18) "") 
             (place "Q&!$zJP-!n|q@!!" (3) "" 10 "R&!$zJP-!n|q@!!" 
                    (356 660 590 746) (351 655 595 751) (359 661 587 745) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "W&!$zJP-!n|q@!!" (3) "" 10 "X&!$zJP-!n|q@!!" 
                    (364 776 582 822) (359 771 587 827) (367 777 579 821) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (link "X&!$zJP-!n|q@!!" "R&!$zJP-!n|q@!!" (473 775 473 745) 3 "" 
                   "" "%%" "%%" "" "" 1 0 (469 752 477 768) (469 767 469 767) 
                   (469 753 469 753) 0 0 "z&!$zJP-!n|q@!!" (468 751 478 769) 
                   (458 740 488 780) (468 751 478 769) 2 0 
                   (nil 1 -12 32 18 12 18 18) ""))
