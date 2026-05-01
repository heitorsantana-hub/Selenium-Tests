package com.aula.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DesafioBonusRelatorio {

    //Variáveis globais
    static int quantitySucess = 0;
    static int quantityError = 0;


    public static void main(String[] args) {
        /**
         * Configurar o Driver
         * E abrir o chrome
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //Renderizar toda página do site


        try{
            System.out.println("=== INICIANDO OS TESTE");

            /*
                Inicializando todos os testes
             */
            boolean teste1 = Desafio1LoginValido.TesteDesafio1(driver);
            boolean teste2 = Desafio2LoginInvalido.TesteDesafio2(driver);
            boolean teste3 = Desafio3CamposVazios.TesteDesafio3(driver);
            boolean teste4 = Desafio4SemPerfil.TesteDesafio4(driver);


            //Testando os testes se houve Sucesso
            if(teste1){
                quantitySucess++;
            }
            else{
                quantityError++;
            }

            if (teste2){
                quantitySucess++;
            }
            else {
                quantityError++;
            }

            if(teste3){
                quantitySucess++;
            }
            else{
                quantityError++;
            }

            if(teste4){
                quantitySucess++;
            }
            else{
                quantityError++;
            }

            //Relátorio Geral
            System.out.println("=== RELÁTORIO GERAL ===");
            System.out.println("Número de Acertos: " + quantitySucess);
            System.out.println("Número de Erros: " + quantityError);

        }
        catch (Exception e){
            System.out.println("Ocorreu erro aqui: " + e.getMessage());
        }
        finally {
            System.out.println("Fechando o navegador...");
            driver.quit();
        }
    }



}
