import org.junit.Test

class DrinkTrayTest {

    @Test
    void should_construct_drink_tray(){
        def tray = new DrinkTray()

        assert tray.serve() == '{"hello":"world"}'
    }

}
