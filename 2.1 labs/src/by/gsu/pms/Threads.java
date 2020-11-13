package by.gsu.pms;

public class Threads {
        private Calculator[] threads;
        private String operationType;

        Threads(int countThreads, String operationType, int maxValue) {
            this.operationType = operationType;

            System.out.println("Введеное кол-во потоков " + countThreads +
                    "\nМаксимальное кол-во: " + maxValue +
                    "\nВыбранная операция:" + operationType);

            if (maxValue > countThreads && maxValue % countThreads == 0) {
                Calculator[] arrayThreads = new Calculator[countThreads];

                int threadCapacity = maxValue / countThreads;
                for (int i = 0; i < countThreads; i++) {

                    int start = i * threadCapacity + 1;
                    int end = i * threadCapacity + threadCapacity;

                    arrayThreads[i] = new Calculator(start, end);
                }
                this.threads = arrayThreads;
            } else {
                System.out.println("Ошибка, введенное maxValue больше введеного countThreads!");
            }
        }

        public void execute() {
            for (Calculator thread: this.threads){
                thread.start();
            }
        }

        public int getResult() throws InterruptedException {
            int result = 0;
            for (Calculator thread: this.threads){
                thread.join();
                switch (this.operationType) {
                    case ("+") -> result += thread.getResult();
                    case ("-") -> result -= thread.getResult();
                    case ("*") -> result *= thread.getResult();
                    default -> System.out.println("Неверный тип выражений!");
                }
            }
            return result;
        }
}
