import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();

        KontoBankowe alior = new KontoBankowe("Alior", r.nextLong(10000), "22090675818");
        KontoBankowe pkobp = new KontoBankowe("PKO BP", r.nextLong(10000), "05262021699");
        KontoBankowe pekao_1 = new KontoBankowe("PEKAO", r.nextLong(10000), "06072336928");
        KontoBankowe pekao_2 = new KontoBankowe("PEKAO", r.nextLong(10000), "36051552814");
        KontoBankowe bnp_paribas = new KontoBankowe("Bnp paribas", r.nextLong(10000), "81060235829");
        KontoBankowe santander = new KontoBankowe("Santander", r.nextLong(10000), "63011048227");

        // dodanie kont bankowych do listy
        List<KontoBankowe> konta = List.of(alior, pkobp, pekao_1, pekao_2, bnp_paribas, santander);

        // pokaz w konsoli
        System.out.println(alior);

        // test wyplaty 1
        Double wyplac = alior.wyplac(200d);
        System.out.println("wyplata z alioru: " + wyplac);

        // test wyplaty 2
        alior.wplac(300d);
        Double wyplac_2 = alior.wyplac(200d);
        System.out.println("wyplata z alioru: " + wyplac_2);
        System.out.println(alior);

        System.out.println("============================================");
        // test przelewy kasy miedzy kontami
        pkobp.wplac(1000d);
        System.out.println(pkobp);
        pkobp.przelew(pekao_1, 500d);
        System.out.println(pkobp);
        System.out.println(pekao_1);

        // kilka wplat
        alior.wplac(200d);
        alior.wplac(300d);
        alior.wplac(400d);
        alior.wplac(500d);
        alior.wplac(500d);
        alior.wplac(500d);
        alior.wplac(500d);

        pkobp.wplac(100d);
        pkobp.wplac(200d);

        pkobp.wyplac(1d);
        pkobp.wyplac(1d);
        pkobp.wyplac(1d);

        pekao_1.wplac(50d);
        pekao_1.wplac(65d);
        pekao_1.wplac(75d);

        pekao_2.wplac(150d);
        pekao_2.wplac(165d);
        pekao_2.wplac(175d);

        bnp_paribas.wplac(1d);
        santander.wplac(10000d);

        // konto z najwieksza liczba operacji
        /*KontoBankowe kontoBankowe = konta.stream().max(Comparator.comparing(KontoBankowe::getLicznikOperacji)).orElse(null);
        System.out.println("konto z najwieksza liczba operacji: " + kontoBankowe);*/
        KontoBankowe max = null;
        for (KontoBankowe kontoBankowe: konta) {
            if (max == null) {
                max = kontoBankowe;
                continue;
            }
            if (max.getLicznikOperacji() < kontoBankowe.getLicznikOperacji()) {
                max = kontoBankowe;
            }
        }
        System.out.println("konto z najwieksza liczba operacji: " + max);

        // konto z najwieksza liczba wyplat
        /*KontoBankowe kb = konta.stream().max(Comparator.comparing(KontoBankowe::getLicznikWyplat)).orElse(null);
        System.out.println("konto z najwieksza liczba wyplat: " + kb);*/
        KontoBankowe max_1 = null;
        for (KontoBankowe kontoBankowe: konta) {
            if (max_1 == null) {
                max_1 = kontoBankowe;
                continue;
            }
            if (max_1.getLicznikWyplat() < kontoBankowe.getLicznikWyplat()) {
                max_1 = kontoBankowe;
            }
        }
        System.out.println("konto z najwieksza liczba wyplat: " + max_1);

        // konto z najwiekszy saldem
        /*KontoBankowe kb_1 = konta.stream().max(Comparator.comparing(KontoBankowe::getDepozyt)).orElse(null);
        System.out.println("konto z najwiekszy saldem: " + kb_1);*/
        KontoBankowe max_saldo = null;
        for (KontoBankowe kontoBankowe: konta) {
            if (max_saldo == null) {
                max_saldo = kontoBankowe;
                continue;
            }
            if (max_saldo.getDepozyt() < kontoBankowe.getDepozyt()) {
                max_saldo = kontoBankowe;
            }
        }
        System.out.println("konto z najwiekszy saldem: " + max_1);

        // ktorego banku kont jest najwiecej
        Map<String, Long> collect = konta.stream().collect(Collectors.groupingBy(KontoBankowe::getNazwaBanku, Collectors.counting()));
        System.out.println(collect);

        konta.stream().collect(Collectors.groupingBy(KontoBankowe::getNazwaBanku, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .ifPresent(System.out::println);
    }
}
