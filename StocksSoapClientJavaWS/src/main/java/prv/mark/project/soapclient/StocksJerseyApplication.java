package prv.mark.project.soapclient;

import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
/*import prv.mark.project.soapclient.entity.StockSymbol;
import prv.mark.project.soapclient.schemas.GetStockPriceRequest;
import prv.mark.project.soapclient.schemas.GetStockPriceResponse;
import prv.mark.project.soapclient.schemas.ObjectFactory;
import prv.mark.project.soapclient.schemas.RequestHeader;*/

/**
 * Stock Ticker client using Jersey Web Services framework for REST (JAX-RS) clients.
 *
 * @author mlglenn on 11/28/2016.
 */
public class StocksJerseyApplication {

    //private static final Logger LOGGER = LoggerFactory.getLogger(StocksJerseyApplication.class);
    private static final String LOG_FILE = "StocksJerseyApplication.log";
    private static int errorCount;
    private static int successCount;

    /*@Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private WebServiceTemplate webServiceTemplate;
    @Autowired
    private Jaxb2Marshaller marshaller;
    @Autowired
    private MessageSource messageSource;

    @Value("${app.stocks.stockListQuery}")
    private String stockListQuery;

    @Value("${app.stocks.stockquote.soap.url}")
    private String stockquoteSoapUrl;

    @Value("${app.stocks.client.name}")
    private String stocksClientName;*/



    /**
     * Spring Boot application entry point.
     *
     * @param args Array of command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Starting StocksJerseyApplication ...");

        //Client client = Client.create();

        ClientConfig config = new ClientConfig();
        //Client client = ClientBuilder.newClient(config);

        //WebTarget target = client.target(getBaseURI());

        /*String response = target.path("rest").
                path("hello").
                request().
                accept(MediaType.TEXT_PLAIN).
                get(Response.class)
                .toString();*/


        /*String plainAnswer =
                target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class);
        String xmlAnswer =
                target.path("rest").path("hello").request().accept(MediaType.TEXT_XML).get(String.class);
        String htmlAnswer=
                target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class);*/

        /*System.out.println(response);
        System.out.println(plainAnswer);
        System.out.println(xmlAnswer);
        System.out.println(htmlAnswer);*/

    }


    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/com.vogella.jersey.first").build();
    }


    //@Override
    //public void run(String... args) throws Exception {

        /*
        Steps:
            1. Open log file
            2. Query database
            3. Submit requests to web service
            4. Record log output
         */

        /*BufferedWriter logFileWriter = new BufferedWriter(new PrintWriter(new File(LOG_FILE)));
        List<StockSymbol> stockSymbolList = getStocks();
        webServiceTemplate.setDefaultUri(stockquoteSoapUrl);

        Instant start = Instant.now();
        String message = "*** {}: Processing stock quotes ... ***" + start;
        LOGGER.info(message);
        writeToLog(message, logFileWriter, StringUtils.EMPTY);

        stockSymbolList.parallelStream()
                .forEach(symbol -> {
                    try {
                        GetStockPriceResponse response = (GetStockPriceResponse)
                                webServiceTemplate.marshalSendAndReceive(buildStockPriceRequest(symbol));

                        if (response == null) {
                            ++errorCount;
                            LOGGER.info("Response is null for stock symbol {}", symbol);
                            writeToLog(symbol.toString(), logFileWriter, "Empty Response from Web Service");
                        } else {
                            ++successCount;
                            LOGGER.info("Received valid response for stock symbol {}", symbol);
                            writeToLog(symbol.toString(), logFileWriter, StringUtils.EMPTY);
                        }
                    } catch (RuntimeException e) {
                        ++errorCount;
                        LOGGER.info("");
                        LOGGER.info("!!! Error processing {}: {}", symbol.toString(), e.getMessage());
                        LOGGER.info("");
                        writeToLog(symbol.toString(), logFileWriter, e.getMessage());
                    }
                });

        Instant end = Instant.now();
        message = "*** {}: END processing stock quotes ... ***" + end;
        LOGGER.info(message);
        writeToLog(message, logFileWriter, StringUtils.EMPTY);

        message = "{} records processed in {} MILLISECONDS" + stockSymbolList.size() + Duration.between(start, end).toMillis();
        LOGGER.info(message);
        writeToLog(message, logFileWriter, StringUtils.EMPTY);

        message = "Number of SUCCESSFUL requests to backend service : {}" + successCount;
        LOGGER.info(message);
        writeToLog(message, logFileWriter, StringUtils.EMPTY);

        message = "Number of FAILED requests to backend service     : {}" + errorCount;
        LOGGER.info(message);
        writeToLog(message, logFileWriter, StringUtils.EMPTY);

        logFileWriter.close();*/
    //}



    private void writeToLog(String lineToWrite, BufferedWriter writer, String errorMsg) {
        try {
            writer.write(lineToWrite);
            if (StringUtils.isNotEmpty(errorMsg)) {
                writer.write("!!! ERROR !!! : " + errorMsg);
            }
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println("ERROR writing to the LOG FILE: " + e.getMessage());
        }
    }

    /*private GetStockPriceRequest buildStockPriceRequest(StockSymbol stockSymbol) {
        ObjectFactory objectFactory = new ObjectFactory();
        RequestHeader requestHeader = objectFactory.createRequestHeader();
        requestHeader.setSource(stocksClientName);
        GetStockPriceRequest request = objectFactory.createGetStockPriceRequest();
        request.setHead(requestHeader);
        request.setTickerSymbol(stockSymbol.getTickerSymbol());
        return request;
    }*/

    /*private List<StockSymbol> getStocks() {
        Instant start = Instant.now();
        System.out.println("*** {}: Retrieving stock symbols ***", start);

        List<StockSymbol> stockSymbolList = jdbcTemplate.query(stockListQuery, new Object[]{},
                (rs, i) -> {
                    StockSymbol stockSymbol = new StockSymbol();
                    stockSymbol.setId(rs.getLong("id"));
                    stockSymbol.setTickerSymbol(rs.getString("ticker_symbol"));
                    return stockSymbol;
                });
        List<StockSymbol> distinctList = stockSymbolList.stream().distinct().collect(Collectors.toList());

        Instant end = Instant.now();
        System.out.println("*** {}: Retrieved {} stock symbols in {} ms ***", end,
                distinctList.size(), Duration.between(start, end).toMillis());

        return stockSymbolList;
    }*/
}
