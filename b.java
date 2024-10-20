package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: C:\Users\HP\Desktop\Hussain Iqbal\7th Semester\TSE\Assignment 1\tools\APK Editor Studio v1.7.1\data\temp\apk\{c2f2c75a-9a82-4128-94f8-5edd7a1ef9ac}\classes.dex */
public final class b {
    public static final b d = new b();
    public final ExecutorService a;
    public final ScheduledExecutorService b;
    public final Executor c;

    /* renamed from: bolts.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\HP\Desktop\Hussain Iqbal\7th Semester\TSE\Assignment 1\tools\APK Editor Studio v1.7.1\data\temp\apk\{c2f2c75a-9a82-4128-94f8-5edd7a1ef9ac}\classes.dex */
    public static class ExecutorC0355b implements Executor {
        public ThreadLocal A;

        public ExecutorC0355b() {
            this.A = new ThreadLocal();
        }

        public final int a() {
            Integer num = (Integer) this.A.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.A.remove();
            } else {
                this.A.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public final int b() {
            Integer num = (Integer) this.A.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.A.set(Integer.valueOf(intValue));
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (b() <= 15) {
                    runnable.run();
                } else {
                    b.a().execute(runnable);
                }
            } finally {
                a();
            }
        }
    }

    public b() {
        this.a = !c() ? Executors.newCachedThreadPool() : bolts.a.b();
        this.b = Executors.newSingleThreadScheduledExecutor();
        this.c = new ExecutorC0355b();
    }

    public static ExecutorService a() {
        return d.a;
    }

    public static Executor b() {
        return d.c;
    }

    public static boolean c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }
}
