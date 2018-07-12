#include <stdlib.h>
#include <stdio.h>
#include <math.h>

int divideIzquierda(int num, int d);
int divideDerecha(int num, int aib, int longitud);

int main()
{
	int a,b,resultado;
	int tam1, tam2;
	float x, x2;
	int iz, ix, da, db;

	/*
	printf ("Productos de nmeros con divide y venceras\n");
	printf ("Ingresa el numero A:\t");
	scanf ("%d",&a);
	printf("Ingresa el numero B:\t");
	scanf ("%d",&b);

	
	tam1=tam(a);
	tam2=tam(b);

	*/
	iz=divideIzquierda(1234, 2);
	ix=divideIzquierda(4321,2);
	da=divideDerecha(1234,iz,4);
	db=divideDerecha(4321,ix,4);

	printf("El lado izquierdo es: %d\n",iz);
	printf("El lado izquierdo es: %d\n",ix);
	printf("El lado derecho es: %d\n",da);
	printf("El lado derecho es: %d\n",db);
	printf("El resultado es el siguente\n");
	
}

int multiplica(int A, int B, int c, int d){
	int ia, da, ib, db;
	int p1, p2, p3, p4;
	int n, n1, n2, n3;

	if(c==1 || d==1){
		return A*B;
	}else{
		/*
		ia=divide(A, c/2);
		da=divide(A, ai ,c);


		ib=divide(B,d/2);
		db=divide(B, ib, d);
		
	p1=multiplica(ia, ib, (c/2), (d/2));
	p2=multiplica(ia, db, (c/2), (d/2));
	p3=multiplica(da, ib, (c/2), (d/2));
	p4=multiplica(da, db, (c/2), (d/2));


	 n2=(int)pow(10, )
	 n3=(int)pow(10, )
	 */
	
	}

}



int tam(int num){
	float x;
	x= floor(log10(num));
	x++;
	return (int)(x);
}

int divideIzquierda(int num, int d){
	int k, x;
	while(d>1){
		x=num/10;
		k=x;
		d--;
	}
	return k;
}

int divideDerecha(int num, int num2, int longitud){
	int x=longitud/2;
	float numero;

		numero=num2*(int)pow(10,x);

	return	(int)numero;

}