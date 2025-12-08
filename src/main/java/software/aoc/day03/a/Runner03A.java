package software.aoc.day03.a;

import software.aoc.Runner;
import software.aoc.day03.Bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Runner03A implements Runner<Integer> {
    private Stream<Bank> banks;

    @Override
    public Integer runFrom(InputStream file) {
        try (InputStreamReader isr = new InputStreamReader(file); BufferedReader br = new BufferedReader(isr)) {
            loadBanksFrom(br);
            return calculateJoltage();
        } catch (IOException e) {
            System.err.println("Error while reading from file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void loadBanksFrom(BufferedReader br) {
        banks = br.lines().map(Bank::new);
    }

    private Integer calculateJoltage() {
        return banks.mapToInt(Runner03A::getBestDigits).sum();
    }

    private static int getBestDigits(Bank bank) {
        return bank.batteryStream().boxed().reduce(new BatteryRecord(0, 0, 0),
                        BatteryRecord::next,
                        (_, b) -> b)
                .getNumber();
    }

    private record BatteryRecord(int lastBestDigit, int digit1, int digit2) {
        public BatteryRecord next(int newDigit) {
            if (newDigit > digit1) return new BatteryRecord(digit1, newDigit, 0);
            return new BatteryRecord(lastBestDigit, digit1, Integer.max(digit2, newDigit));
        }

        public Integer getNumber() {
            if (digit2 == 0) return lastBestDigit * 10 + digit1;
            return digit1 * 10 + digit2;
        }
    }
}
