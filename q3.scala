class Account(private var balance:Double){

    def deposite(amount:Double):Unit = {
        balance += amount
        println(s"Deposites $amount. New balance: $balance")
    }

    def withdraw(amount:Double):Unit = {
        if(amount > balance){
            println("Insufficient balance")
        }else{
            balance -= amount
            println(s"Withdraw $amount. New balance $$${balance}")
        }
    }

    def transfer(amount:Double, receiverAccount:Account):Unit = {
        if(amount > balance){
             println("Insufficient balance for transfer")
        }else{
           this.withdraw((amount))
           receiverAccount.deposite((amount))
           println(s"Transfer Success")
        }
    }

    def getBalance:Double = balance

    override def toString(): String = s"Account balance is $balance"

}

object Main extends App{

    val account1 = new Account(8000.00)
    val account2 = new Account(4000.00)

    println("Initial Balances....")
    println("Account 1 - " + account1.getBalance)
    println("Account 2 - " + account2.getBalance)

    account1.deposite(1000.00)
    account1.withdraw(500.00)
    account1.transfer(60.00,account2)

    println("Final Balances....")
    println("Account 1 - " + account1.getBalance)
    println("Account 2 - " + account2.getBalance)
}