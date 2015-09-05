maven_layout()

jar_library(
  name='guava',
  jars=[
    jar('com.google.guava', 'guava', '18.0')
  ]
)

jar_library(
  name='junit',
  jars=[
    jar('junit', 'junit', '4.12')
  ]
)

java_library(
  name='lib',
  sources=rglobs('src/main/java/*.java'),
  resources=[
    ':lib_resources',
  ],
  dependencies=[
    ':guava',
  ]
)

resources(
  name='lib_resources',
  sources=rglobs('src/main/resources/*.txt'),
)

junit_tests(
  name='lib_tests',
  sources=rglobs('src/test/java/*.java'),
  resources=[
    ':test_resources',
  ],
  dependencies=[
    ':guava',
    ':junit',
    ':lib',
  ]
)

resources(
  name='test_resources',
  sources=rglobs('src/test/resources/*.txt'),
)

