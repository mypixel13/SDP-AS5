# Foundation Strategy — House Builder (Assignment #5, Strategy pattern)

The house builder chooses a foundation technology (strip / slab / pile / screw pile) depending on the soil.
Each technology is an interchangeable algorithm that calculates concrete volume, duration and cost.

## Structure
| Pattern role | Class |
|---|---|
| Strategy interface | `FoundationStrategy` |
| Concrete strategies | `StripFoundation`, `SlabFoundation`, `PileFoundation`, `ScrewPileFoundation` |
| Context | `HouseBuilder` (`setFoundationStrategy` switches at runtime) |
| Client | `Main` + `FoundationSelector` (soil -> strategy lookup table) |

## Build & run
```
javac -d out src/housebuilder/foundation/*.java
java -cp out housebuilder.foundation.Main
```

## Clean Code principles applied
1. **Polymorphism instead of conditionals** — `HouseBuilder` has no if/switch on foundation type; the selection is an `EnumMap` lookup in the client.
2. **Intention-revealing names** — `StripFoundation`, `PILE_SPACING_METERS`, `CONCRETE_CURING_DAYS`, `planFoundation()`.
3. **Single Responsibility** — each strategy contains exactly one calculation algorithm; the selector only maps soil to strategy.
4. **Context is algorithm-agnostic** — `HouseBuilder` depends only on the `FoundationStrategy` interface (Dependency Inversion).
5. **Open/Closed, extensibility** — `ScrewPileFoundation` was added and registered in `Main` without modifying any existing class.
6. **No magic numbers** — every coefficient is a named constant.
7. **Immutable data** — `HouseSpec` and `FoundationPlan` are records; the context null-checks its strategy (fail fast).
