#include<stdio.h>
#include<string.h>
int q,r,t1=0,t2=1,t,rem,mi;
void gcd(int r1,int r2){
rem=r1;
while(r2!=0){
q=(int)r1/r2;
r=r1%r2;
r1=r2;
r2=r;
t=t1-q*t2;
t1=t2;
t2=t;
}
if(r1==1){
if(t1<0){
mi=rem+t1;
}
else{
mi=t1;
}}
else{
mi=0;
}}

int main(){
char p[100],c[100],s[100];
int ak,mk,i;
printf("Enter plain text: ");
scanf("%s",p);
printf("Enter additive key: ");
scanf("%d",&ak);
printf("Enter multiplicative key: ");
scanf("%d",&mk);
for(i=0;i<strlen(p);i++){
c[i]=(char)(((int)p[i]-65)*mk)%26;
c[i]=(char)(((int)c[i]+ak)%26)+65;
}
printf("Encypted text through affine cipher:");
for(i=0;i<strlen(p);i++){
printf("%c",c[i]);
}
printf("\n");
gcd(26,mk);
if(mi==0){
printf("MI DOESNT EXIST");
return 0;
}
for(i=0;i<strlen(p);i++){
int a=((int)c[i]-65-ak)%26;
if(a<0){
a=a+26;}
s[i]=(char)a;
int b=(((int)s[i]*mi)%26)+65;
s[i]=(char)b;
}
printf("Decypted text: ");
for(i=0;i<strlen(p);i++){
printf("%c",s[i]);
}
return 0;
}

OUTPUT:-

student@CSEUGLAB5-SYS17:~$ ./affine
Enter plain text: HELLOHARSHITHOWAREYOU
Enter additive key: 9
Enter multiplicative key: 5
Encypted text through aFFINE cipher:SDMMBSJQVSXASBPJQDZBF
Decypted text: HELLOHARSHITHOWAREYOU
