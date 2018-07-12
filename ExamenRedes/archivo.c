//cracion de archivos en windowns 
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(){
	int i, ram;
	
	FILE* archivo=NULL;
	char* nomarchivo[1000]={"dato.txt", "dato1.txt", "dato2.txt", "dato3.txt","dato4.txt","dato5.txt","dato6.txt","dato7.txt","dato8.txt","dato9.txt"};
	char* cadenas[1000]={"cadena", "cadena1","cadena2","cadena3","cadena4","cadena5","cadena6","cadena7","cadena8","cadena9"};
	
	
	for(i=0;i<10;i++){
		ram=rand()%(0+9);
			
			archivo=fopen(nomarchivo[i],"w");
			if(archivo==NULL) return -1;
			fprintf(archivo,cadenas[ram]);
			fclose(archivo);

	}
	
	
	return 0;
}



