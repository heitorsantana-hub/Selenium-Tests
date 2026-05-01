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

public class Desafio3CamposVazios {

    public static boolean TesteDesafio3(WebDriver driver) {

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

            System.out.println("\n--- TESTE DE LOGIN VAZIO ---");

            // Criar um objeto WebDriverWait para esperas inteligentes
            // Ele espera até 10 segundos por um elemento aparecer
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            //Procura o campo e não insere o dados
            WebElement campoUser = driver.findElement(By.id("username"));
            campoUser.clear();
            campoUser.sendKeys("");
            System.out.println("\nUsuario inserido: ");

            //Procura o campo e não insere o dados
            WebElement campoSenha = driver.findElement(By.id("password"));
            campoSenha.clear();
            campoSenha.sendKeys("");
            System.out.println("Senha inserida: ");

            //Procura o campo e não insere o dados
            WebElement dropDown = driver.findElement(By.id("perfil"));
            Select select = new Select(dropDown);
            select.selectByIndex(0);
            System.out.println("Selecionando ");

            //Procura o campo e clica
            WebElement btnLogin = driver.findElement(By.id("btnLogin"));
            btnLogin.click();
            System.out.println("✓ Botão de login clicado");

            //Procura a mensagem e armazena na variavel
            WebElement messagemError = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("msgError"))
            );
            String textoError = messagemError.getText();
            System.out.println("Mensagem Exibida: " + textoError);

            if (textoError.contains("inválido")){
                System.out.println("✅ TESTE 3 PASSOU - Login Vazio com sucesso!");
            }
            else {
                System.out.println("❌ TESTE 3 FALHOU - Mensagem inesperada");
            }

            //Captura de Tela
            CapturaTela.capturarScrenShot(driver, "/Users/heitorreis/selenium-atividade/desafio3-campos-vazios.png");
            System.out.println("Captura de Tela feita");

            Thread.sleep(3000); //Time de 3 segundos


        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        finally {
            System.out.println("\nFechando navegador...");
            driver.quit();
        }

        return true;
    }

}
