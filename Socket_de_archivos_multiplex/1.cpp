#include<stdio.h>
#include<stdlib.h>
#include <string.h> 

typedef struct dina{
	char elementos;
	struct dina *sig;//auto referencia
}pila;

void checarpilavacia(pila *q);
pila *crear();
pila *adicionar(pila *);
pila *eliminar(pila *);
void liberar(pila *);
void mostrar(pila *q);

int main(){
	int tam, j;
	char pal[100];
	pila *arriba=NULL;

		printf("Introduce la cadena que desea verificar bajo el L={a^nb^n|n>=1}\n");
		scanf("%s", &pal);
		tam=strlen(pal);
		printf("%d\n",tam);
		printf("%d\n",tam/2);
	
	for(j=0;j<=tam;j++){
		if(pal[j]=='a'){
		arriba=adicionar(arriba);
		}else if(pal[j]=='b'){
		arriba=eliminar(arriba);
		}
	}
	
	printf("La pila es la siguiente\n");
	mostrar(arriba);


	if(arriba==NULL){
		printf("La cadena es valida\n");
	}else{
		printf("La cadena no es valida\n");
	}
	
	liberar(arriba);
return 0;	
}

pila *crear(){
	pila *aux;
	aux=(pila*)malloc(sizeof(pila));
	if(!aux){
		printf("No hay memoria");
		exit (1);
	}
return aux;	
}
void mostrar(pila *q){	//muestra todos los elemento que se encuentren en la cola 
pila *aux;
	aux=q;
	if(aux != NULL){
		printf("%c\n", q->elementos);
		aux=q->sig;
		mostrar(aux);
    }
    else return;
    
    
return;	
}

pila *adicionar(pila *q){
	pila *aux;
	aux=crear();

	aux->elementos='x';
	printf("\n %c elemento adicionado\n\n", aux->elementos);
	aux->sig=q;
return aux;	
}

pila *eliminar(pila *q){
	pila *aux;
	printf("\n %c fue eliminado\n\n", q->elementos);
	aux=q->sig;
	free(q);
return aux;	
}
 
void checarpilavacia(pila *q){
	if(q==NULL){
		printf("La pila esta vacia\n");
	}
	printf("La pila tiene elementos\n");
	return;
}

void liberar(pila *q){
    if(!q)
        return;   
    liberar(q->sig);    
	free(q);
return;	
}
