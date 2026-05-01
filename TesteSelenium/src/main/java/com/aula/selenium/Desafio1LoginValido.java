package com.aula.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class Desafio1LoginValido {

    public static boolean TesteDesafio1(WebDriver driver) {

        /**
         * Configuração e inicialização do ChromeDriver
         */
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Drivers configurados...");

        try{
            driver.manage().window().maximize(); //Maximizando Tela
            String caminhoFile = "file:///Users/heitorreis/selenium-atividade/site-teste-simples.html";
            driver.get(caminhoFile); //Abrindo página
            System.out.println("Abrindo página...");

            System.out.println("\n--- TESTE DE LOGIN ---");

            // Criar um objeto WebDriverWait para esperas inteligentes
            // Ele espera até 10 segundos por um elemento aparecer
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            //Procura o campo e insere o dados
            WebElement campoUser = driver.findElement(By.id("username"));
            campoUser.clear();
            campoUser.sendKeys("admin");
            System.out.println("\nUsuario inserido: admin");

            //Procura o campo e insere o dados
            WebElement campoSenha = driver.findElement(By.id("password"));
            campoSenha.clear();
            campoSenha.sendKeys("123");
            System.out.println("Senha inserida: 123");

            //Procura o campo e insere o dados
            WebElement dropDown = driver.findElement(By.id("perfil"));
            Select select = new Select(dropDown);
            select.selectByIndex(1);
            System.out.println("Selecionando primeira opção");

            //Procura o campo e insere o dados
            WebElement btnLogin = driver.findElement(By.id("btnLogin"));
            btnLogin.click();
            System.out.println("✓ Botão de login clicado");

            //Procura a mensagem e armazena na variavel
            WebElement mensagemSucesso = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("msgSuccess"))
            );
            String textoSucesso = mensagemSucesso.getText();
            System.out.println("Mensagem Exibida: " + textoSucesso);

            //Se a mensagem contem a palavra sucesso
            if (textoSucesso.contains("sucesso")){
                System.out.println("✅ TESTE 1 PASSOU - Login realizado com sucesso!"); // O teste passou
            }
            else {
                System.out.println("❌ TESTE 1 FALHOU - Mensagem inesperada"); //Se não falhou o texto
            }

            //Captura de Tela
            CapturaTela.capturarScrenShot(driver, "/Users/heitorreis/selenium-atividade/desafio1-sucesso.png");
            System.out.println("Captura de Tela feita");

            Thread.sleep(3000); //Time de 3 segundos


        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        }


        return true;
    }

}
