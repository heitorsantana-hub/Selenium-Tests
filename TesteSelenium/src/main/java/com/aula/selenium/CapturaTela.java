package com.aula.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CapturaTela {

    public static void capturarScrenShot(WebDriver driver, String caminhoDoArquivo){
        try{
            // Captura print como arquivo temporário
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File arquivoTemporario = screenshot.getScreenshotAs(OutputType.FILE);

            //Copia a print para o caminho desejado
            Files.copy(arquivoTemporario.toPath(), Paths.get(caminhoDoArquivo));

            System.out.println("✓ Screenshot salvo em: " + caminhoDoArquivo);
        }
        catch (Exception e){
            System.out.println("❌ Erro ao salvar screenshot: " + e.getMessage());
        }
    }

}
