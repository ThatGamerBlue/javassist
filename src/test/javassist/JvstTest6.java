package javassist;

public class JvstTest6 extends JvstTestRoot {
	public JvstTest6(String name) {
		super(name);
	}

	public void testResolverDefaultPackage() throws Exception {
		ClassPool cp = ClassPool.getDefault();
		CtClass clazz = cp.makeClass("test6.GeneratedClass");
		clazz.addMethod(CtNewMethod.make("public static void test() { test6.ClassInPackage.field; }", clazz));

		try {
			CtClass clazz2 = cp.makeClass("DefaultPackageClass");
			clazz2.addMethod(CtNewMethod.make("public static void test() { test6.ClassInPackage.field; }", clazz2));
			fail("test6.ClassInPackage should not be found while in the default package");
		} catch (Exception ignored) {}
	}
}
