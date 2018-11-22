package Thread;

public class ThreadDemo {

	public static void main(String[] args) {
		Numbers num = new Numbers();
		Object x = new Object();
		Thread thr1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (x) {
					for (int j = 0; j < 100; j++) {
						if (j % 2 == 0) {
							num.evenNumber(j);
						} else {
							try {
//								System.out.println("even wait...");
								x.wait();
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						x.notifyAll();
					}
				}
			}

		});

		Thread thr2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (x) {
					for (int j = 1; j < 100; j++) {
						if (j % 2 != 0) {
							num.oddNumber(j);
							
						} else {
							try {
//								System.out.println("odd wait...");
								x.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						x.notifyAll();
					}
				}
			}

		});

		thr2.start();
		thr1.start();

	}

}
