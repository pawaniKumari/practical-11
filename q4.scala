case class Account(id:String, balance:Double)

type Bank = List[Account]

def negativeBalanceAccounts(bank:Bank):List[Account] = {
    bank.filter(_.balance < 0)
}

def totalBalance(bank:Bank):Double = {
    bank.map(_.balance).sum
}

def interest(bank:Bank):Bank = {
    bank.map {account =>
        val newBalance = account.balance match {
            case b if b > 0 => b * (1 + 0.05)
            case b if b < 0 => b * (1 - 0.1)
            case b => b
        }
        account.copy(balance = newBalance)
    }
}

object  BankApp extends App {
    val accounts = List(
        Account("001", 10000.00),
        Account("002", 1000.00),
        Account("003", -70000.00),
        Account("004", 500.00)
    )

    println("Accounts with negative balances:")
    negativeBalanceAccounts(accounts).foreach(println)

    println(s"Total balance: ${totalBalance(accounts)}")

    println("Accounts after applying interest:")
    interest(accounts).foreach(println)
}