# With Correctly Configured SourceRoots

## Targets that use source roots defined above their source roots

The Resources target/task does not work correctly:
```console
$ git reset --hard above_source_root
HEAD is now at ac7a981 Initial commit of a minimal single module maven-layout project in pants configured from the root.
$ ./pants clean-all test ::
...
12:25:37 00:03   [test]
12:25:37 00:03     [run_prep_command]
12:25:37 00:03     [test]
12:25:37 00:03     [pytest]
12:25:37 00:03     [junit]
                   Invalidated 1 target.
12:25:37 00:03       [bootstrap-junit]
12:25:37 00:03       [bootstrap-jar-tool]
12:25:38 00:04       [jar-tool]
12:25:38 00:04       [bootstrap-jarjar]
12:25:39 00:05       [shade-junit]
12:25:45 00:11       [run]
                     Auto-detected 8 processors, using -parallel-threads=8
                     .E.E
                     Time: 0.043
                     There were 2 failures:
                     1) testSupplied(org.example.LibraryTest)
                     java.lang.IllegalArgumentException: resource test_res.txt relative to org.example.LibraryTest not found.
                      at com.google.common.base.Preconditions.checkArgument(Preconditions.java:145)
                      at com.google.common.io.Resources.getResource(Resources.java:209)
                      at org.example.LibraryTest.testSupplied(LibraryTest.java:22)
                      at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
                      at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
                      at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
                      at java.lang.reflect.Method.invoke(Method.java:606)
                      at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
                      at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
                      at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
                      at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
                      at __shaded_by_pants__.org.pantsbuild.tools.junit.withretry.BlockJUnit4ClassRunnerWithRetry$InvokeWithRetry.evaluate(BlockJUnit4ClassRunnerWithRetry.java:57)
                      at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
                      at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
                      at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
                      at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
                      at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
                      at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
                      at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
                      at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
                      at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
                      at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.CompositeRequest.runChild(CompositeRequest.java:66)
                      at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConcurrentCompositeRequest$1$1.run(ConcurrentCompositeRequest.java:36)
                      at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConcurrentRunnerScheduler.finished(ConcurrentRunnerScheduler.java:85)
                      at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConcurrentCompositeRequest$1.evaluate(ConcurrentCompositeRequest.java:45)
                      at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
                      at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
                      at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConsoleRunnerImpl.run(ConsoleRunnerImpl.java:334)
                      at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConsoleRunnerImpl.main(ConsoleRunnerImpl.java:660)
                      at org.pantsbuild.tools.junit.ConsoleRunner.main(ConsoleRunner.java:12)
                     2) testDefault(org.example.LibraryTest)
                     java.lang.IllegalArgumentException: resource res.txt relative to org.example.Library not found.
                      at com.google.common.base.Preconditions.checkArgument(Preconditions.java:145)
                      at com.google.common.io.Resources.getResource(Resources.java:209)
                      at org.example.Library$1.get(Library.java:15)
                      at org.example.Library$1.get(Library.java:13)
                      at com.google.common.base.Absent.or(Absent.java:60)
                      at org.example.Library.loadMotd(Library.java:13)
                      at org.example.LibraryTest.testDefault(LibraryTest.java:17)
                      at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
                      at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
                      at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
                      at java.lang.reflect.Method.invoke(Method.java:606)
                      at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
                      at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
                      at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
                      at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
                      at __shaded_by_pants__.org.pantsbuild.tools.junit.withretry.BlockJUnit4ClassRunnerWithRetry$InvokeWithRetry.evaluate(BlockJUnit4ClassRunnerWithRetry.java:57)
                      at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
                      at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
                      at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
                      at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
                      at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
                      at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
                      at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
                      at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
                      at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
                      at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.CompositeRequest.runChild(CompositeRequest.java:66)
                      at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConcurrentCompositeRequest$1$1.run(ConcurrentCompositeRequest.java:36)
                      at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConcurrentRunnerScheduler.finished(ConcurrentRunnerScheduler.java:85)
                      at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConcurrentCompositeRequest$1.evaluate(ConcurrentCompositeRequest.java:45)
                      at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
                      at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
                      at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConsoleRunnerImpl.run(ConsoleRunnerImpl.java:334)
                      at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConsoleRunnerImpl.main(ConsoleRunnerImpl.java:660)
                      at org.pantsbuild.tools.junit.ConsoleRunner.main(ConsoleRunner.java:12)
                     
                     FAILURES!!!
                     Tests run: 2,  Failures: 2
                     
                     
FAILURE: java org.pantsbuild.tools.junit.ConsoleRunner ... exited non-zero (2); 0 failed targets.


               Waiting for background workers to finish.
12:25:45 00:11   [complete]
               FAILURE
```

And in fact the resources are isolated as-if they had no SourceRoot defined:
```console
$ tree -a .pants.d/resources
.pants.d/resources
├── prepare
│   ├── .lib_resources
│   │   └── src
│   │       └── main
│   │           └── resources
│   │               └── org
│   │                   └── example
│   │                       └── res.txt
│   └── .test_resources
│       └── src
│           └── test
│               └── resources
│                   └── org
│                       └── example
│                           └── test_res.txt
└── services
    ├── .lib
    └── .lib_tests

16 directories, 2 files
```

## Targets that use source roots defined exactly at their source roots

This is enough to fix things:
```console
$ git reset --hard at_source_root 
HEAD is now at cd954f0 Convert to targets housed at or under their source_root.
$ ./pants test ::
INFO] Detected git repository at /home/jsirois/Desktop/pants/issues_2141/maven on branch master

12:33:32 00:00 [main]
               See a report at: http://localhost:46441/run/pants_run_2015_09_05_12_33_32_175
12:33:32 00:00   [bootstrap]
12:33:32 00:00   [setup]
12:33:32 00:00     [parse]
               Executing tasks in goals: bootstrap -> imports -> jvm-platform-validate -> unpack-jars -> deferred-sources -> gen -> resolve -> compile -> resources -> test
12:33:32 00:00   [bootstrap]
12:33:32 00:00     [bootstrap-jvm-tools]
12:33:32 00:00   [imports]
12:33:32 00:00     [ivy-imports]
12:33:32 00:00   [jvm-platform-validate]
12:33:32 00:00     [jvm-platform-validate]WARN] No default jvm platform is defined.

                   Invalidated 2 targets.
12:33:32 00:00   [unpack-jars]
12:33:32 00:00     [unpack-jars]
12:33:32 00:00   [deferred-sources]
12:33:32 00:00     [deferred-sources]
12:33:32 00:00   [gen]
12:33:32 00:00     [thrift]
12:33:32 00:00     [protoc]
12:33:32 00:00     [antlr]
12:33:32 00:00     [ragel]
12:33:32 00:00     [jaxb]
12:33:32 00:00     [wire]
12:33:32 00:00   [resolve]
12:33:32 00:00     [ivy]
12:33:32 00:00   [compile]
12:33:32 00:00     [compile]
12:33:32 00:00     [jvm]
12:33:32 00:00       [jvm-compilers]
12:33:32 00:00         [apt-pre]
12:33:32 00:00         [java-pre]
12:33:32 00:00         [zinc-pre]
12:33:32 00:00         [java-prepare]
12:33:32 00:00           [find-deleted-sources]
12:33:32 00:00           [prepare-analysis]
12:33:32 00:00         [java-execute]
                       Invalidated 2 targets.
12:33:32 00:00           [partition-analysis]
                       Compiling 2 java sources in 2 targets (partition 1 of 1).
12:33:32 00:00           [compile]
                         
12:33:32 00:00             [jmake]
                           Jmake version 1.3.8-10
                           Opening project database...  Done.
                           Writing project database...  Done.
                           
12:33:32 00:00           [trim-downstream-analysis]
12:33:32 00:00         [java-finalize]
12:33:32 00:00         [apt-post]
12:33:32 00:00         [java-post]
12:33:32 00:00         [zinc-post]
12:33:32 00:00     [jvm-dep-check]
                   Invalidated 4 targets.
12:33:32 00:00   [resources]
12:33:32 00:00     [prepare]
                   Invalidated 2 targets.
12:33:32 00:00     [services]
                   Invalidated 2 targets.
12:33:32 00:00   [test]
12:33:32 00:00     [run_prep_command]
12:33:32 00:00     [test]
12:33:32 00:00     [pytest]
12:33:32 00:00     [junit]
12:33:32 00:00       [run]
                     Auto-detected 8 processors, using -parallel-threads=8
                     ..
                     Time: 0.047
                     
                     OK (2 tests)
                     
                     
               Waiting for background workers to finish.
12:33:33 00:01   [complete]
               SUCCESS
```

And the isolated resources are layed out as expected:
```console
$ tree -a .pants.d/resources/
.pants.d/resources/
├── prepare
│   ├── .lib_resources
│   │   └── src
│   │       └── main
│   │           └── resources
│   │               └── org
│   │                   └── example
│   │                       └── res.txt
│   ├── .test_resources
│   │   └── src
│   │       └── test
│   │           └── resources
│   │               └── org
│   │                   └── example
│   │                       └── test_res.txt
│   ├── src.main.resources.lib_resources
│   │   └── org
│   │       └── example
│   │           └── res.txt
│   └── src.test.resources.test_resources
│       └── org
│           └── example
│               └── test_res.txt
└── services
    ├── .lib
    ├── .lib_tests
    ├── src.main.java.lib
    └── src.test.java.lib_tests

24 directories, 4 files
```
