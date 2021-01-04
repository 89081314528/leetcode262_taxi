package ru.julia.taxi.taxi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.julia.taxi.taxi.dto.Rate;
import ru.julia.taxi.taxi.service.TaxiService;

import java.util.List;

/**
 * 262. Trips and Users
 * The Trips table holds all taxi trips. Each trip has a unique Id, while Client_Id and Driver_Id are both foreign keys to the Users_Id at the Users table. Status is an ENUM type of (‘completed’, ‘cancelled_by_driver’, ‘cancelled_by_client’).
 * <p>
 * +----+--------------------+----------+------
 * | Id |  Status            |Request_at|Banned
 * +----+--------------------+----------+------
 * | 1  |completed          |1          |no
 * | 2  |cancelled_by_driver|1          |yes
 * | 3  |completed          |1          |no
 * | 4  |cancelled_by_client|1          |no
 * | 5  |completed          |2          |no
 * | 6  |completed          |2          |yes
 * | 7  |completed          |2          |no
 * | 8  |completed          |3          |yes
 * | 9  |completed          |3          |no
 * | 10 |cancelled_by_driver|3          |no
 * +----+-----------+-----------+---------+--------------------+----------+
 * Write a SQL query to find the cancellation rate of requests made by unbanned users
 * (both client and driver must be unbanned) between Oct 1, 2013 and Oct 3, 2013.
 * The cancellation rate is computed by dividing the number of canceled (by client or driver)
 * requests made by unbanned users by the total number of requests made by unbanned users.
 * <p>
 * For the above tables, your SQL query should return the following rows with the cancellation
 * rate being rounded to two decimal places.
 * <p>
 * +------------+-------------------+
 * |     Day    | Cancellation Rate |
 * +------------+-------------------+
 * | 2013-10-01 |       0.33        |
 * | 2013-10-02 |       0.00        |
 * | 2013-10-03 |       0.50        |
 * +------------+-------------------+
 */
@RestController
public class leetcode262_taxiController {
    private final TaxiService taxiService;

    public leetcode262_taxiController(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    @RequestMapping("/")
    public static String hello() {
        return "hello";
    }

    @RequestMapping("/rate")
    public List<Rate> rate() {
        return taxiService.rate();
    }
}
