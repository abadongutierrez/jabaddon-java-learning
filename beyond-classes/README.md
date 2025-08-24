# Beyond Classes

## Sealing Classes

A sealed class is a class that restricts which other classes may directly extend it.

These are brand new to Java 17.

Sealed Class Keywords

* sealed: Indicates that a class or interface may only be extended/implemented by named classes or interfaces
* permits: Used with the sealed keyword to list the classes and interfaces allowed
* non-sealed: Applied to a class or interface that extends a sealed class, indicating that it can be extended by unspecified classes

### Clases extending Sealed Classes

Every class that directly extends a sealed class must specify exactly one of the following three modifiers: final, sealed, or non-sealed.

### Omitting the `permits` Clause

| Location of direct subclasses	                                | permits clause              |
|---------------------------------------------------------------|-----------------------------|
| In a different file from the sealed class                     | Required                    |
| In the same file as the sealed class                          | Permitted, but not required |
| Nested inside of the sealed class | Permitted, but not required |

### Sealing Interfaces

