# poc-juni5-all-features

## 1 - Lifecycle

Annotations:
- @BeforeEach
- @AfterEach
- @BeforeAll
- @AfterAll
- @Test
- @DisplayName
- @TestInstance
- assertEquals
- assertThrows


## 2 - Parameterized Tests

- @ValueSource
- @NullAndEmptySource
- @CsvSource
- @CsvFileSource
- @MethodSource


## 3 - Nested Test

## 4 - Advanced assertions

- @assertIterableEquals - item by item (exact)
- assertAll
- assertThrows
- assertDoesNotThrow
- assertTimeout
- assertLinesMatch - item by item + regex

## 5 - Mockito
- @Mock - cria um objeto falso
- @InjectMocks - cria a classe que sera testada e injeta os mocks nela
- @ExtendWith - adiciona uma funcionalidade a mais ao JUnit
- verify
- when
- thenReturn
- thenAnswer - retorna dinamicamente o que foi passado Ex: "test@email.com"
- never
- times

## 6 - Argument Captor