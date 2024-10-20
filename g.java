package bolts;

/* loaded from: C:\Users\HP\Desktop\Hussain Iqbal\7th Semester\TSE\Assignment 1\tools\APK Editor Studio v1.7.1\data\temp\apk\{c2f2c75a-9a82-4128-94f8-5edd7a1ef9ac}\classes.dex */
public class g {
    public final f a = new f();

    public f a() {
        return this.a;
    }

    public void b() {
        if (!e()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void c(Exception exc) {
        if (!f(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public void d(Object obj) {
        if (!g(obj)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public boolean e() {
        return this.a.p();
    }

    public boolean f(Exception exc) {
        return this.a.q(exc);
    }

    public boolean g(Object obj) {
        return this.a.r(obj);
    }
}
