package bolts;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\HP\Desktop\Hussain Iqbal\7th Semester\TSE\Assignment 1\tools\APK Editor Studio v1.7.1\data\temp\apk\{c2f2c75a-9a82-4128-94f8-5edd7a1ef9ac}\classes.dex */
public final class a {
    public static final a b = new a();
    public static final int c;
    public static final int d;
    public static final int e;
    public final Executor a = new b();

    /* loaded from: C:\Users\HP\Desktop\Hussain Iqbal\7th Semester\TSE\Assignment 1\tools\APK Editor Studio v1.7.1\data\temp\apk\{c2f2c75a-9a82-4128-94f8-5edd7a1ef9ac}\classes.dex */
    public static class b implements Executor {
        public b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        c = availableProcessors;
        d = availableProcessors + 1;
        e = (availableProcessors * 2) + 1;
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        threadPoolExecutor.allowCoreThreadTimeOut(z);
    }

    public static ExecutorService b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(d, e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    public static Executor c() {
        return b.a;
    }
}
