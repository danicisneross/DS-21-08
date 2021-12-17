package e1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpresionTest {

    /*Criterios de Busqueda*/

    Origen o1 = new Origen("A Coruña");
    Origen o2 = new Origen("Pontevedra");
    Origen o3 = new Origen("Lugo");
    Origen o4 = new Origen("Vigo");
    Origen o5 = new Origen("Santiago");
    Destino d1 = new Destino("Pontevedra");
    Destino d2 = new Destino("Lugo");
    Destino d3 = new Destino("A Coruña");
    Destino d4 = new Destino("Vigo");
    Destino d5 = new Destino("Santiago");
    Precio p1 = new Precio(15.0);
    Precio p2 = new Precio(10.0);
    Precio p3 = new Precio(5.0);
    Precio p4 = new Precio(20.0);
    Fecha f1 = new Fecha("2022-12-10");
    Fecha f2 = new Fecha("2022-11-08");
    Fecha f3 = new Fecha("2022-05-22");
    Fecha f4 = new Fecha("2022-04-27");

    /*Billetes con los que vamos a comparar para nuestras busquedas*/

    Billete b1 = new Billete("A Coruña", "Vigo",15.0, "2021-05-22");
    Billete b2 = new Billete("Vigo", "A Coruña",10.5, "2022-12-05");
    Billete b3 = new Billete("Santiago", "Pontevedra",5.0, "2022-11-08");
    Billete b4 = new Billete("Lugo", "Santiago",2.0, "2021-07-05");
    Billete b5 = new Billete("Pontevedra", "Vigo",8.5, "2022-02-14");
    Billete b6 = new Billete("A Coruña", "Lugo",10.0, "2022-01-01");
    Billete b7 = new Billete("Vigo", "Santiago",14.95, "2022-07-27");


    @Test
    void TestBasic() {

        //Revisamos que introduce bien los datos
        assertEquals("A Coruña", o1.getOrigen());
        assertEquals("Pontevedra", o2.getOrigen());

        assertEquals("Lugo", d2.getDestino());
        assertEquals("Vigo", d4.getDestino());

        assertEquals(15.0, p1.getPrecio());
        assertEquals(5.0, p3.getPrecio());

        assertEquals("2022-11-08", f2.getFecha());
        assertEquals("2022-04-27", f4.getFecha());


        assertEquals("A Coruña", b1.getOrigen());
        assertEquals("Vigo", b1.getDestino());
        assertEquals(15.0, b1.getPrecio());
        assertEquals("22/05/2021", b1.getFecha());

        assertEquals("Santiago", b3.getOrigen());
        assertEquals("Pontevedra", b3.getDestino());
        assertEquals(5.0, b3.getPrecio());
        assertEquals("08/11/2022", b3.getFecha());

        assertEquals("Pontevedra", b5.getOrigen());
        assertEquals("Vigo", b5.getDestino());
        assertEquals(8.5, b5.getPrecio());
        assertEquals("14/02/2022", b5.getFecha());

        assertEquals("Lugo", b4.getOrigen());
        assertEquals("Santiago", b4.getDestino());
        assertEquals(2.0, b4.getPrecio());
        assertEquals("05/07/2021", b4.getFecha());

        //Exepciones
        assertThrows(IllegalArgumentException.class, () -> new Precio(-12.0));
        assertThrows(IllegalArgumentException.class, () -> new Billete("Vigo","Lugo",0.0, "2021-09-28"));

    }

    @Test
    void hacerBusqueda(){
        List<Billete> BilletesGeneral = new ArrayList<>();

        BilletesGeneral.add(b1);
        BilletesGeneral.add(b2);
        BilletesGeneral.add(b3);
        BilletesGeneral.add(b4);
        BilletesGeneral.add(b5);
        BilletesGeneral.add(b6);
        BilletesGeneral.add(b7);

        List<Billete> BilleteOrigen = new ArrayList<>();

        BilleteOrigen.add(b1);
        BilleteOrigen.add(b6);

        assertEquals(BilleteOrigen, o1.hacerBusqueda(BilletesGeneral));

    }




}