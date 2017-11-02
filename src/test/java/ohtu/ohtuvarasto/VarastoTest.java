package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void alkusaldo() {
        Varasto varasto2 = new Varasto(20, 5);
        assertEquals(5, varasto2.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenAlkusaldo() {
        Varasto varasto2 = new Varasto(20, -5);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLaittaaLiikaaVarastoon() {
        Varasto varasto2 = new Varasto(20, 25);
        assertEquals(20, varasto2.getSaldo(), vertailuTarkkuus);
    }
    

    
    @Test
    public void konstruktoriLuoNegatiivisenTilavuuden() {
        Varasto varasto2 = new Varasto(-20);
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void toinenKonstruktoriLuoNegatiivisenTilavuuden() {
        Varasto varasto2 = new Varasto(-20, 5);
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
    }
    

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void uudellaVarastollaOikeaSaldo() {
        Varasto varasto2 = new Varasto(20, 5);
        assertEquals(5, varasto2.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaysEiLisaaYlitilavuuden() {
        varasto.lisaaVarastoon(11);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenOtto() {
        varasto.lisaaVarastoon(8);
        double saatuMaara = varasto.otaVarastosta(-1);
        assertEquals(0, saatuMaara, vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenLisays() {
        varasto.lisaaVarastoon(-1);        
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void ottaminenOttaaKorkeintaanTyhjaksi() {
        varasto.lisaaVarastoon(8);
        double saatuMaara = varasto.otaVarastosta(9);
        assertEquals(8, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void merkkijonoesitys() {
        varasto.lisaaVarastoon(8);       
        
        assertEquals("saldo = 8.0, vielä tilaa 2.0", varasto.toString());
    }

}