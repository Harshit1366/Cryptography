#include<stdio.h>
#include<string.h>
void main(){
char p[100],c[100],s[100];
int key,i;
printf("Enter plain text: ");
scanf("%s",p);
printf("Enter key: ");
scanf("%d",&key);
for(i=0;i<strlen(p);i++){
c[i]=(char)((int)p[i]-65+key)%26+65;
}
printf("Encypted text through additive cipher:");
for(i=0;i<strlen(p);i++){
printf("%c",c[i]);
}
printf("\n");
for(i=0;i<strlen(p);i++){
s[i]=(char)((int)c[i]-65-key)%26;
if(s[i]<0){
s[i]=s[i]+26;
}
s[i]=s[i]+65;
}
printf("Decypted text: ");
for(i=0;i<strlen(p);i++){
printf("%c",s[i]);
}
}

OUTPUT:-

student@CSEUGLAB5-SYS17:~$ ./additive
Enter plain text: HOWAREYOUBROTHER
Enter key: 7
Encypted text through additive cipher:OVDHYLFVBIYVAOLY
Decypted text: HOWAREYOUBROTHER
