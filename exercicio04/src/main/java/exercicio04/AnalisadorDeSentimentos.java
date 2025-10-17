package exercicio04;

import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.models.DocumentSentiment;
import com.azure.ai.textanalytics.models.SentimentConfidenceScores;
import com.azure.core.credential.AzureKeyCredential;

public class AnalisadorDeSentimentos {

    private static final String AZURE_ENDPOINT = "https://ia2ti2.cognitiveservices.azure.com/";
    private static final String AZURE_KEY = ""; //chave azure, barrada pelo github

    public static void main(String[] args) {
    
        TextAnalyticsClient client = new TextAnalyticsClientBuilder()
                .endpoint(AZURE_ENDPOINT)
                .credential(new AzureKeyCredential(AZURE_KEY))
                .buildClient();

        String textoParaAnalisar = "Estou insatisfeita com o servico"; //texto para analise

        System.out.println("Analisando: \"" + textoParaAnalisar + "\"");

        //Analizando
        DocumentSentiment documentSentiment = client.analyzeSentiment(textoParaAnalisar);

        SentimentConfidenceScores scores = documentSentiment.getConfidenceScores();

        System.out.println("Analise final:");
        System.out.printf("Sentimento Geral: %s%n", documentSentiment.getSentiment());
        System.out.printf("Pontuação de Confiança:%n  - Positivo: %.2f%n  - Neutro: %.2f%n  - Negativo: %.2f%n",
                scores.getPositive(), scores.getNeutral(), scores.getNegative());
    }
}