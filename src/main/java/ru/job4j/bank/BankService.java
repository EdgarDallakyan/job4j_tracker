package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Класс описывает работу банковского сервиса
 * @author Даллакян Эдгар
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение клиентов банка и привязанных к ним счетов осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет клиента в систему, если такого клиента ещё нет
     * @param user добавляется в список всех клиентов системы
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет клиента из системы
     * @param passport серия и номер паспорта клиента, по которым удаляется клиент
     */

    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет новый счёт клиента
     * Если в методе поиска по паспорту клиент находится, но не имеет счёта,
     * счёт добавляется
     * @param passport серия и номер паспорта клиента
     * @param account счёт, который добавляется
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод находит клиента по серии и номеру паспорта
     * @param passport серия и номер паспорта клиента
     * @return возвращает либо клиента по серии и номеру паспорта,
     * либо null, если клиент не найден
     */

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод находит счёт клиента по реквизитам
     * Происходит проверка на наличие клиента в системе
     * @param passport серия и номер паспорта клиента
     * @param requisite реквизиты, по которым производится поиск
     * @return возвращает либо счёт по реквизитам, либо null,
     * если он не найден
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account result = null;
        if (user != null) {
            List<Account> accountsList = users.get(user);
            for (Account account : accountsList) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод переводит деньги с одного банковского счёта на другой
     * Если счета по предоставленным реквизитам существуют
     * и на счёте отправителя сумма не меньше, чем та, которая передаётся в метод,
     * то происходит перевод
     * @param sourcePassport серия и номер паспорта отправителя
     * @param sourceRequisite реквизиты счёта отправителя
     * @param destinationPassport серия и номер паспорта получателя
     * @param destinationRequisite реквизиты счёта получателя
     * @param amount сумма отправления
     * @return true, если деньги переведены
     */

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}