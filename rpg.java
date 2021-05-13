import java.util.Scanner;
import java.util.Random;

public class rpg {
     
  static int racaUsuario(){ 
     Scanner leitor = new Scanner(System.in);
     System.out.println("Escolha sua raça"); 
     System.out.println("1 - Elfo");
     System.out.println("2 - Humano");
     System.out.println("3 - Mago ");
     return leitor.nextInt(); 
  } 
 static int ataqueHumano() { 
  Scanner leitor = new Scanner(System.in); 
  System.out.println("Escolha seu ataque");
  System.out.println("(1) - Soco");
  System.out.println("(2) - Rasteira");
  return leitor.nextInt(); 
 }
 static int ataqueElfo() { 
     Scanner leitor = new Scanner(System.in);
     System.out.println("Escolha seu ataque");
     System.out.println("(1) - Arco");
     System.out.println("(2) - Arco Fogo");
     return leitor.nextInt(); 
 }
 static int ataqueMago() { 
     Scanner leitor = new Scanner(System.in); 
     System.out.println("Escolha seu ataque");
     System.out.println("(1) - Bola de fogo");
     System.out.println("(2) - Meteoro");
     return leitor.nextInt(); 
 }
 static int ataqueComputador() {
  Random gerador = new Random();
  return gerador.nextInt(3) + 1;
 }

 static void imprimeHP(int hpUsuario, int hpComputador, int contagemEspeciais, String nomeRaca) { 
  System.out.println("------- Info -------");
  System.out.println("- Raça: " + nomeRaca); 
  System.out.println("- HP Usuario: " + hpUsuario); 
  System.out.println("- HP Computador: " + hpComputador); 
  System.out.println("- Contagem Especiais: " + contagemEspeciais); 
  System.out.println("--------------------");
 }

 static int batalha() {
  int racaUsuario; 
  int i = 1; 
  int hpUsuario = 0;
  String nomeRaca = ""; 
  int hpComputador; 
  int contagemEspecial = 0; 
  int escolhaAtaque; 
  System.out.println("====================");
  System.out.println("INICIO " + i);
  System.out.println("====================\n");
  racaUsuario = racaUsuario(); 
  switch (racaUsuario) { 
     case 1:
       System.out.println("Elfo");
       break;
    case 2:
        System.out.println("Humano");
        break;
    case 3:
        System.out.println("Mago");
        break;
    default: 
        System.out.println("Opcao invalida");
        break;
  }
  if(racaUsuario == 1) {
     hpUsuario = 100;
     contagemEspecial = 7;
     nomeRaca = "Elfo";
  }else if (racaUsuario == 2) {
     hpUsuario = 150;
     contagemEspecial = 5;
     nomeRaca = "Humano";
  }else if (racaUsuario == 3) {
     hpUsuario = 75;
     contagemEspecial = 10;
     nomeRaca = "Mago";
  }
  while (hpUsuario > 0) { 
   hpComputador = 10 + i; 

   while (hpUsuario > 0 && hpComputador > 0) { 
    imprimeHP(hpUsuario, hpComputador, contagemEspecial, nomeRaca);
   
    escolhaAtaque = 0; 

    if(racaUsuario == 1) {
     escolhaAtaque = ataqueElfo(); 
    }else if(racaUsuario == 2) {
     escolhaAtaque = ataqueHumano(); 
    }else if(racaUsuario == 3) {
     escolhaAtaque = ataqueMago(); 
    }
    
    switch (escolhaAtaque) {
    case 1:
     System.out.println(racaUsuario);
     if(racaUsuario == 1) {
      System.out.println("Usuario deu uma flechada");
     }else if(racaUsuario == 2) {
      System.out.println("Usuario deu um soco");
     }else if(racaUsuario == 3) {
      System.out.println("Usuario atacou uma bola de fogo");
     }
     hpComputador -= 7; 
     break;
    case 2:
     if(contagemEspecial <= 0) {
         System.out.println("Acabou o especial");
     }else if(contagemEspecial > 0){
        if(racaUsuario == 1) {
         System.out.println("Usuario deu uma flechada na cabeça");
        }else if(racaUsuario == 2) {
         System.out.println("Usuario deu um voadora");
        }else if(racaUsuario == 3) {
         System.out.println("Usuario atacou um meteoro");
        }
        hpComputador -= 20;
        contagemEspecial--;
     }
     break;
    default:
     System.out.println("Opcao invalida");
     break;
    }
    if (hpComputador > 0) {
     escolhaAtaque = ataqueComputador();
     switch (escolhaAtaque) {
     case 1:
      System.out.println("Computador aplicou um soco.");
      hpUsuario -= 2 + (int)(i / 10); 
      break;
     case 2:
      System.out.println("Computador aplicou um chute.");
      hpUsuario -= 3 + (int)(i / 10);
      break;
     case 3:
      System.out.println("Computador aplicou um ataque especial.");
      hpUsuario -= 4 + (int)(i / 20); 
      break;
     }
    } else {
     System.out.println("Inimigo derrotado");
    } 
   }
   if (hpUsuario > 0) {
    hpUsuario += 5; 
    if (hpUsuario > 150) {
     hpUsuario = 150;
    }
    if (i % 10 == 0) {
     contagemEspecial++;
     if (contagemEspecial > 5) {
      contagemEspecial = 5;
     }
    }
   }
   i++;
  }
  return i; 
 } 

 public static void main(String[] args) {
  Scanner leitor = new  Scanner(System.in);
  int continua = 1; 
  int recorde = 0; 
  while (continua == 1) { 

   int pontos = batalha(); 
   System.out.println("Usuario chegou a " + pontos + " pontos.");
   if (pontos > recorde) { 
    recorde = pontos;
   }
   System.out.println("RECORDE ATUAL = " + recorde); 
   System.out.println("Fim de jogo. Deseja continuar? (1) Sim (2) Nao"); 
   continua = leitor.nextInt(); 
  }
       }
}