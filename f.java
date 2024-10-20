package bolts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: C:\Users\HP\Desktop\Hussain Iqbal\7th Semester\TSE\Assignment 1\tools\APK Editor Studio v1.7.1\data\temp\apk\{c2f2c75a-9a82-4128-94f8-5edd7a1ef9ac}\classes.dex */
public class f {
    public static final ExecutorService i = bolts.b.a();
    public static final Executor j = bolts.b.b();
    public static final Executor k = bolts.a.c();
    public static f l = new f((Object) null);
    public static f m = new f(Boolean.TRUE);
    public static f n = new f(Boolean.FALSE);
    public static f o = new f(true);
    public boolean b;
    public boolean c;
    public Object d;
    public Exception e;
    public boolean f;
    public h g;
    public final Object a = new Object();
    public List h = new ArrayList();

    /* loaded from: C:\Users\HP\Desktop\Hussain Iqbal\7th Semester\TSE\Assignment 1\tools\APK Editor Studio v1.7.1\data\temp\apk\{c2f2c75a-9a82-4128-94f8-5edd7a1ef9ac}\classes.dex */
    public class a implements bolts.d {
        public final /* synthetic */ g a;
        public final /* synthetic */ bolts.d b;
        public final /* synthetic */ Executor c;

        public a(g gVar, bolts.d dVar, Executor executor, bolts.c cVar) {
            this.a = gVar;
            this.b = dVar;
            this.c = executor;
        }

        @Override // bolts.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(f fVar) {
            f.d(this.a, this.b, fVar, this.c, null);
            return null;
        }
    }

    /* loaded from: C:\Users\HP\Desktop\Hussain Iqbal\7th Semester\TSE\Assignment 1\tools\APK Editor Studio v1.7.1\data\temp\apk\{c2f2c75a-9a82-4128-94f8-5edd7a1ef9ac}\classes.dex */
    public static class b implements Runnable {
        public final /* synthetic */ g A;
        public final /* synthetic */ bolts.d B;
        public final /* synthetic */ f C;

        public b(bolts.c cVar, g gVar, bolts.d dVar, f fVar) {
            this.A = gVar;
            this.B = dVar;
            this.C = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.A.d(this.B.a(this.C));
            } catch (CancellationException unused) {
                this.A.b();
            } catch (Exception e) {
                this.A.c(e);
            }
        }
    }

    /* loaded from: C:\Users\HP\Desktop\Hussain Iqbal\7th Semester\TSE\Assignment 1\tools\APK Editor Studio v1.7.1\data\temp\apk\{c2f2c75a-9a82-4128-94f8-5edd7a1ef9ac}\classes.dex */
    public static class c implements Runnable {
        public final /* synthetic */ g A;
        public final /* synthetic */ Callable B;

        public c(bolts.c cVar, g gVar, Callable callable) {
            this.A = gVar;
            this.B = callable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.A.d(this.B.call());
            } catch (CancellationException unused) {
                this.A.b();
            } catch (Exception e) {
                this.A.c(e);
            }
        }
    }

    /* loaded from: C:\Users\HP\Desktop\Hussain Iqbal\7th Semester\TSE\Assignment 1\tools\APK Editor Studio v1.7.1\data\temp\apk\{c2f2c75a-9a82-4128-94f8-5edd7a1ef9ac}\classes.dex */
    public interface d {
    }

    public f() {
    }

    public static f b(Callable callable, Executor executor) {
        return c(callable, executor, null);
    }

    public static f c(Callable callable, Executor executor, bolts.c cVar) {
        g gVar = new g();
        try {
            executor.execute(new c(cVar, gVar, callable));
        } catch (Exception e) {
            gVar.c(new e(e));
        }
        return gVar.a();
    }

    public static void d(g gVar, bolts.d dVar, f fVar, Executor executor, bolts.c cVar) {
        try {
            executor.execute(new b(cVar, gVar, dVar, fVar));
        } catch (Exception e) {
            gVar.c(new e(e));
        }
    }

    public static f g(Exception exc) {
        g gVar = new g();
        gVar.c(exc);
        return gVar.a();
    }

    public static f h(Object obj) {
        if (obj == null) {
            return l;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? m : n;
        }
        g gVar = new g();
        gVar.d(obj);
        return gVar.a();
    }

    public static d k() {
        return null;
    }

    public f e(bolts.d dVar) {
        return f(dVar, j, null);
    }

    public f f(bolts.d dVar, Executor executor, bolts.c cVar) {
        boolean m2;
        g gVar = new g();
        synchronized (this.a) {
            m2 = m();
            if (!m2) {
                this.h.add(new a(gVar, dVar, executor, cVar));
            }
        }
        if (m2) {
            d(gVar, dVar, this, executor, cVar);
        }
        return gVar.a();
    }

    public Exception i() {
        Exception exc;
        synchronized (this.a) {
            if (this.e != null) {
                this.f = true;
                h hVar = this.g;
                if (hVar != null) {
                    hVar.a();
                    this.g = null;
                }
            }
            exc = this.e;
        }
        return exc;
    }

    public Object j() {
        Object obj;
        synchronized (this.a) {
            obj = this.d;
        }
        return obj;
    }

    public boolean l() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    public boolean m() {
        boolean z;
        synchronized (this.a) {
            z = this.b;
        }
        return z;
    }

    public boolean n() {
        boolean z;
        synchronized (this.a) {
            z = i() != null;
        }
        return z;
    }

    public final void o() {
        synchronized (this.a) {
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                try {
                    ((bolts.d) it.next()).a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.h = null;
        }
    }

    public boolean p() {
        synchronized (this.a) {
            if (this.b) {
                return false;
            }
            this.b = true;
            this.c = true;
            this.a.notifyAll();
            o();
            return true;
        }
    }

    public boolean q(Exception exc) {
        synchronized (this.a) {
            if (this.b) {
                return false;
            }
            this.b = true;
            this.e = exc;
            this.f = false;
            this.a.notifyAll();
            o();
            if (!this.f) {
                k();
            }
            return true;
        }
    }

    public boolean r(Object obj) {
        synchronized (this.a) {
            if (this.b) {
                return false;
            }
            this.b = true;
            this.d = obj;
            this.a.notifyAll();
            o();
            return true;
        }
    }

    public f(Object obj) {
        r(obj);
    }

    public f(boolean z) {
        if (z) {
            p();
        } else {
            r(null);
        }
    }
}
