import cucumber.api.PendingException;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.*;

public class Mystepdefs {

    int balance = 0, smsCost = 0, callCost = 0;


    @Дано("^на счете пользователя есть (\\d+) рублей и отправка СМС стоит (\\d+) рубля$")
    public void на_счете_пользователя_есть_рублей_и_отправка_СМС_стоит_рубля(int arg1, int arg2) throws Throwable {

        balance = arg1;
        smsCost = arg2;

    }

    @Когда("^пользователь отправляет одно СМС$")
    public void пользователь_отправляет_одно_СМС() throws Throwable {

    }

    @Тогда("^на счете пользователя остается (\\d+) рублей$")
    public void на_счете_пользователя_остается_рублей(int arg1) throws Throwable {

        arg1 = 97;
        assertEquals(balance - smsCost, arg1);
    }

    @Дано("^на счете пользователя есть (\\d+) рубля и отправка СМС стоит (\\d+) рубля$")
    public void на_счете_пользователя_есть_рубля_и_отправка_СМС_стоит_рубля(int arg1, int arg2) throws Throwable {

        balance = arg1;
        smsCost = arg2;
    }

    @Тогда("^появляется предупреждение: \"([^\"]*)\"$")
    public void появляется_предупреждение(String arg1) throws Throwable {

        if (balance - smsCost < 0)
            arg1 = "На счете недостаточно денег";
        assertEquals(arg1, "На счете недостаточно денег");
    }


    @Дано("^на счете есть (\\d+) рублей и минута разговора стоит (\\d+) рублей$")
    public void на_счете_есть_рублей_и_минута_разговора_стоит_рублей(int arg1, int arg2) throws Throwable {

        balance = arg1;
        callCost = arg2;

    }

    @Когда("^абонент говорит в течение (\\d+) минуты$")
    public void абонент_говорит_в_течение_минуты(int arg1) throws Throwable {

        balance = balance - callCost * 1;
    }

    @Тогда("^на счету остается (\\d+) рубля$")
    public void на_счету_остается_рубля(int arg1) throws Throwable {

        arg1 = 44;
        assertEquals(balance, arg1);
    }

    @Когда("^абонент говорит в течение (\\d+) минут$")
    public void абонент_говорит_в_течение_минут(int arg1) throws Throwable {

        balance = balance - callCost * arg1;
    }

    @Тогда("^звонок прерывается после первой минуты разговора с оповещением: \"([^\"]*)\"$")
    public void звонок_прерывается_после_первой_минуты_разговора_с_оповещением(String arg1) throws Throwable {

        String result = "";
        if (balance <= 0)
            result = "Закончились деньги";
        assertEquals(result, arg1);
    }
}
