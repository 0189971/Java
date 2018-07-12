(UMLStudio "6.0" project)
(repository "" 0)
(notation "UML.not")
(genProfile 34 4 "" "" 0 "" "" 700 360 98 78 50 50 80 50 80 60 0 0)
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
(masters (master "k'!7wJP-!n|q@!!" 1 3 "FlujosDeSalidaTexto" "" "" "" "" "" 5 
                 (("nombreArchivo" "String" "" "" "" "" 1 16 
                                   "m'!7wJP-!n|q@!!")) 
                 (("getNombreArchivo" "String" "" 3 16 nil nil 
                                      "n'!7wJP-!n|q@!!" "") 
                  ("setNombreArchivo" "void" "" 3 16 
                                      (("otroArchivo" "String" "" 0)) nil 
                                      "o'!7wJP-!n|q@!!" "") 
                  ("getFlujoTexto" "FileWriter" "" 3 144 
                                   (("archivo" "String" "" 0)) nil 
                                   "p'!7wJP-!n|q@!!" "")) nil nil 10 "") 
         (master "_'!7wJP-!n|q@!!" 1 3 "FlujosDeEntrada" "" "" "" "" "" 5 
                 (("dIn" "DataInputStream" "" "" "" "" 1 16 "a'!7wJP-!n|q@!!") 
                  ("nombreArchivo" "String" "" "" "" "" 1 16 "b'!7wJP-!n|q@!!") 
                  ("fInStr" "FileInputStream" "" "" "" "" 1 16 
                            "c'!7wJP-!n|q@!!")) 
                 (("getFlujoArchivo" "FileInputStream" "" 0 16 nil 
                                     (("FileNotFoundException" 0)) 
                                     "d'!7wJP-!n|q@!!" "") 
                  ("getNombreArchivo" "String" "" 0 16 nil nil 
                                      "e'!7wJP-!n|q@!!" "") 
                  ("getDataInputStream" "DataInputStream" "" 0 16 nil 
                                        (("FileNotFoundException" 0)) 
                                        "f'!7wJP-!n|q@!!" "") 
                  ("setNombreArchivo" "void" "" 0 16 
                                      (("nombreAr" "String" "" 0)) nil 
                                      "g'!7wJP-!n|q@!!" "") 
                  ("setFileInputStream" "void" "" 0 16 
                                        (("otroFile" "FileInputStream" "" 0)) 
                                        nil "h'!7wJP-!n|q@!!" "") 
                  ("setDataInputStream" "void" "" 0 16 
                                        (("otroDOut" "DataInputStream" "" 0)) 
                                        nil "i'!7wJP-!n|q@!!" "") 
                  ("getFlujo" "DataInputStream" "" 3 144 
                              (("nombreArchivo" "String" "" 0)) nil 
                              "j'!7wJP-!n|q@!!" "")) nil nil 10 "") 
         (master "X'!7wJP-!n|q@!!" 1 3 "IFlujosFactory" "" "" "" "" "" 7 nil 
                 (("creaFlujoDeSalida" "FlujosDeSalida" "" 3 144 nil nil 
                                       "Z'!7wJP-!n|q@!!" "") 
                  ("creaFlujoDeEntrada" "FlujosDeEntrada" "" 3 144 nil nil 
                                        "['!7wJP-!n|q@!!" "") 
                  ("creaFlujoDeSalidaTexto" "FlujosDeSalidaTexto" "" 3 144 nil 
                                            nil "\'!7wJP-!n|q@!!" "") 
                  ("creaFlujoDeEntradaTexto" "FlujosDeEntradaTexto" "" 3 144 
                                             nil nil "]'!7wJP-!n|q@!!" "") 
                  ("creaFlujoAleatorio" "FlujoAleatorio" "" 3 144 nil nil 
                                        " '!7wJP-!n|q@!!" "")) nil nil 10 "") 
         (master "U'!7wJP-!n|q@!!" 1 3 "FlujoRandomAccessFile" "" "" "" "" "" 
                 1 nil 
                 (("getFlujoAleatorio" "RandomAccessFile" "" 3 16 
                                       (("archivo" "String" "" 0) 
                                        ("mod" "String" "" 0)) nil 
                                       "W'!7wJP-!n|q@!!" "")) nil nil 10 "") 
         (master "R'!7wJP-!n|q@!!" 1 3 "FlujoFileReader" "" "" "" "" "" 1 nil 
                 (("getFlujoTexto" "FileReader" "" 3 16 
                                   (("archivo" "String" "" 0)) nil 
                                   "T'!7wJP-!n|q@!!" "")) nil nil 10 "") 
         (master "L'!7wJP-!n|q@!!" 1 3 "FlujosDeEntradaTexto" "" "" "" "" "" 5 
                 (("nombreArchivo" "String" "" "" "" "" 1 16 
                                   "N'!7wJP-!n|q@!!")) 
                 (("getNombreArchivo" "String" "" 3 16 nil nil 
                                      "O'!7wJP-!n|q@!!" "") 
                  ("setNombreArchivo" "void" "" 3 16 
                                      (("otroArchivo" "String" "" 0)) nil 
                                      "P'!7wJP-!n|q@!!" "") 
                  ("getFlujoTexto" "FileReader" "" 3 144 
                                   (("archivo" "String" "" 0)) nil 
                                   "Q'!7wJP-!n|q@!!" "")) nil nil 10 "") 
         (master "I'!7wJP-!n|q@!!" 1 3 "FlujoBufferedOutputStream" "" "" "" "" 
                 "" 1 nil 
                 (("getFlujo" "DataOutputStream" "" 3 16 
                              (("nombreArchivo" "String" "" 0)) nil 
                              "K'!7wJP-!n|q@!!" "")) nil nil 10 "") 
         (master "A'!7wJP-!n|q@!!" 1 3 "FlujoAleatorio" "" "" "" "" "" 5 
                 (("nombreArchivo" "String" "" "" "" "" 1 16 "C'!7wJP-!n|q@!!") 
                  ("modo" "String" "" "" "" "" 1 16 "D'!7wJP-!n|q@!!")) 
                 (("getNombreArchivo" "String" "" 3 16 nil nil 
                                      "E'!7wJP-!n|q@!!" "") 
                  ("getModo" "String" "" 3 16 nil nil "F'!7wJP-!n|q@!!" "") 
                  ("setNombreYModo" "void" "" 3 16 
                                    (("archivo" "String" "" 0) 
                                     ("mod" "String" "" 0)) nil 
                                    "G'!7wJP-!n|q@!!" "") 
                  ("getFlujoAleatorio" "RandomAccessFile" "" 3 144 
                                       (("archivo" "String" "" 0) 
                                        ("mod" "String" "" 0)) nil 
                                       "H'!7wJP-!n|q@!!" "")) nil nil 10 "") 
         (master ">'!7wJP-!n|q@!!" 1 3 "FlujoBufferedInputStream" "" "" "" "" 
                 "" 1 nil 
                 (("getFlujo" "DataInputStream" "" 3 16 
                              (("nombreArchivo" "String" "" 0)) nil 
                              "@'!7wJP-!n|q@!!" "")) nil nil 10 "") 
         (master ";'!7wJP-!n|q@!!" 1 3 "FlujoFileWriter" "" "" "" "" "" 1 nil 
                 (("getFlujoTexto" "FileWriter" "" 3 16 
                                   (("archivo" "String" "" 0)) nil 
                                   "='!7wJP-!n|q@!!" "")) nil nil 10 "") 
         (master "8'!7wJP-!n|q@!!" 1 4 "PruebaFlujos" "" "" "" "" "" 1 nil 
                 (("main" "void" "" 3 17 (("args" "String[]" "" 0)) nil 
                          ":'!7wJP-!n|q@!!" "")) nil nil 10 "") 
         (master "1'!7wJP-!n|q@!!" 1 3 "FlujosFactory" "" "" "" "" "" 1 nil 
                 (("creaFlujoDeEntrada" "FlujosDeEntrada" "" 3 16 nil nil 
                                        "3'!7wJP-!n|q@!!" "") 
                  ("creaFlujoDeSalida" "FlujosDeSalida" "" 3 16 nil nil 
                                       "4'!7wJP-!n|q@!!" "") 
                  ("creaFlujoDeSalidaTexto" "FlujosDeSalidaTexto" "" 3 16 nil 
                                            nil "5'!7wJP-!n|q@!!" "") 
                  ("creaFlujoDeEntradaTexto" "FlujosDeEntradaTexto" "" 3 16 
                                             nil nil "6'!7wJP-!n|q@!!" "") 
                  ("creaFlujoAleatorio" "FlujoAleatorio" "" 3 16 nil nil 
                                        "7'!7wJP-!n|q@!!" "")) nil nil 10 "") 
         (master "%'!7wJP-!n|q@!!" 1 3 "FlujosDeSalida" "" "" "" "" "" 5 
                 (("dOut" "DataOutputStream" "" "" "" "" 1 16 
                          "''!7wJP-!n|q@!!") 
                  ("nombreArchivo" "String" "" "" "" "" 1 16 "('!7wJP-!n|q@!!") 
                  ("fOutStr" "FileOutputStream" "" "" "" "" 1 16 
                             ")'!7wJP-!n|q@!!")) 
                 (("getFlujoArchivo" "FileOutputStream" "" 0 16 nil 
                                     (("FileNotFoundException" 0)) 
                                     "*'!7wJP-!n|q@!!" "") 
                  ("getNombreArchivo" "String" "" 0 16 nil nil 
                                      "+'!7wJP-!n|q@!!" "") 
                  ("getDataInputStream" "DataOutputStream" "" 0 16 nil 
                                        (("FileNotFoundException" 0)) 
                                        ",'!7wJP-!n|q@!!" "") 
                  ("setNombreArchivo" "void" "" 0 16 
                                      (("nombreAr" "String" "" 0)) nil 
                                      "-'!7wJP-!n|q@!!" "") 
                  ("setFile" "void" "" 0 16 
                             (("otroFile" "FileOutputStream" "" 0)) nil 
                             ".'!7wJP-!n|q@!!" "") 
                  ("setDataOutputStream" "void" "" 0 16 
                                         (("otroDOut" "DataOutputStream" "" 0)) 
                                         nil "/'!7wJP-!n|q@!!" "") 
                  ("getFlujo" "DataOutputStream" "" 3 144 
                              (("nombreArchivo" "String" "" 0)) nil 
                              "0'!7wJP-!n|q@!!" "")) nil nil 10 "") 
         (master "^"'!7wJP-!n|q@!!" 1 3 "PruebaFlujos2" "" "" "" "" "" 1 nil 
                 (("main" "void" "" 3 17 (("args" "String[]" "" 0)) nil 
                          "$'!7wJP-!n|q@!!" "")) nil nil 10 "") 
         (master "}&!7wJP-!n|q@!!" 1 3 "PruebaFlujos1" "" "" "" "" "" 1 nil 
                 (("main" "void" "" 3 17 (("args" "String[]" "" 0)) nil 
                          "!'!7wJP-!n|q@!!" "")) nil nil 10 ""))
(customModel "|&!KwJP-!n|q@!!" 0 3 "Untitled" "" "" 17 "" "" 1.000000 1.000000 
             (0 0 827 1168) (0 0 827 1168) 
             (place "}&!7wJP-!n|q@!!" (2) "" 10 "~&!7wJP-!n|q@!!" 
                    (184 96 276 122) (179 91 281 127) (185 97 275 121) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "^"'!7wJP-!n|q@!!" (2) "" 10 "#'!7wJP-!n|q@!!" 
                    (308 96 400 122) (303 91 405 127) (309 97 399 121) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "%'!7wJP-!n|q@!!" (2) "" 10 "&'!7wJP-!n|q@!!" 
                    (624 192 720 218) (619 187 725 223) (625 193 719 217) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "1'!7wJP-!n|q@!!" (2) "" 10 "2'!7wJP-!n|q@!!" 
                    (588 96 672 122) (583 91 677 127) (589 97 671 121) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "8'!7wJP-!n|q@!!" (2) "" 10 "9'!7wJP-!n|q@!!" 
                    (64 96 150 122) (59 91 155 127) (65 97 149 121) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place ";'!7wJP-!n|q@!!" (2) "" 10 "<'!7wJP-!n|q@!!" 
                    (36 276 134 302) (31 271 139 307) (37 277 133 301) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place ">'!7wJP-!n|q@!!" (2) "" 10 "?'!7wJP-!n|q@!!" 
                    (436 248 590 274) (431 243 595 279) (438 249 588 273) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "A'!7wJP-!n|q@!!" (2) "" 10 "B'!7wJP-!n|q@!!" 
                    (312 192 398 218) (307 187 403 223) (313 193 397 217) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "I'!7wJP-!n|q@!!" (2) "" 10 "J'!7wJP-!n|q@!!" 
                    (592 248 754 274) (587 243 759 279) (594 249 752 273) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "L'!7wJP-!n|q@!!" (2) "" 10 "M'!7wJP-!n|q@!!" 
                    (160 192 294 218) (155 187 299 223) (161 193 293 217) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "R'!7wJP-!n|q@!!" (2) "" 10 "S'!7wJP-!n|q@!!" 
                    (176 248 276 274) (171 243 281 279) (177 249 275 273) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "U'!7wJP-!n|q@!!" (2) "" 10 "V'!7wJP-!n|q@!!" 
                    (280 248 428 274) (275 243 433 279) (282 249 426 273) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "X'!7wJP-!n|q@!!" (2) "" 10 "Y'!7wJP-!n|q@!!" 
                    (440 96 528 122) (435 91 533 127) (441 97 527 121) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "_'!7wJP-!n|q@!!" (2) "" 10 "`'!7wJP-!n|q@!!" 
                    (460 188 564 214) (455 183 569 219) (461 189 563 213) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (place "k'!7wJP-!n|q@!!" (2) "" 10 "l'!7wJP-!n|q@!!" 
                    (20 224 154 250) (15 219 159 255) (21 225 153 249) 1 0 
                    (nil 1 -12 32 18 12 18 18) "") 
             (link "2'!7wJP-!n|q@!!" "Y'!7wJP-!n|q@!!" (587 109 527 109) 3 "" 
                   "" "%%" "%%" "" "" 1 0 (552 100 562 118) (579 105 579 105) 
                   (535 105 535 105) 101 101 "q'!7wJP-!n|q@!!" 
                   (552 100 562 118) (522 89 592 129) (552 100 562 118) 2 0 
                   (nil 1 -12 32 18 12 18 18) "") 
             (link "?'!7wJP-!n|q@!!" "`'!7wJP-!n|q@!!" (512 247 512 213) 3 "" 
                   "" "%%" "%%" "" "" 1 0 (508 222 516 238) (508 239 508 239) 
                   (508 221 508 221) 0 0 "s'!7wJP-!n|q@!!" (507 221 517 239) 
                   (497 208 527 252) (507 221 517 239) 2 0 
                   (nil 1 -12 32 18 12 18 18) "") 
             (link "J'!7wJP-!n|q@!!" "&'!7wJP-!n|q@!!" (672 247 672 217) 3 "" 
                   "" "%%" "%%" "" "" 1 0 (668 224 676 240) (668 239 668 239) 
                   (668 225 668 225) 0 0 "t'!7wJP-!n|q@!!" (667 223 677 241) 
                   (657 212 687 252) (667 223 677 241) 2 0 
                   (nil 1 -12 32 18 12 18 18) "") 
             (link "S'!7wJP-!n|q@!!" "M'!7wJP-!n|q@!!" (226 247 226 217) 3 "" 
                   "" "%%" "%%" "" "" 1 0 (222 224 230 240) (222 239 222 239) 
                   (222 225 222 225) 0 0 "u'!7wJP-!n|q@!!" (221 223 231 241) 
                   (211 212 241 252) (221 223 231 241) 2 0 
                   (nil 1 -12 32 18 12 18 18) "") 
             (link "V'!7wJP-!n|q@!!" "B'!7wJP-!n|q@!!" (354 247 354 217) 3 "" 
                   "" "%%" "%%" "" "" 1 0 (350 224 358 240) (350 239 350 239) 
                   (350 225 350 225) 0 0 "v'!7wJP-!n|q@!!" (349 223 359 241) 
                   (339 212 369 252) (349 223 359 241) 2 0 
                   (nil 1 -12 32 18 12 18 18) "") 
             (link "<'!7wJP-!n|q@!!" "l'!7wJP-!n|q@!!" (85 275 86 249) 3 "" 
                   "" "%%" "%%" "" "" 1 0 (76 255 94 269) (81 267 81 267) 
                   (90 257 90 257) 0 0 "w'!H2AP-!1!`$+!" (75 249 95 275) 
                   (70 241 101 283) (75 254 95 270) 2 0 
                   (nil 1 -12 32 18 12 18 18) ""))
