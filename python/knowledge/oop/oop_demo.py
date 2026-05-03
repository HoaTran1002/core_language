class Animal:
    def speak(self) -> str:
        raise NotImplementedError


class Dog(Animal):
    def __init__(self, name: str) -> None:
        self.name = name

    def speak(self) -> str:
        return f"{self.name} says woof"


if __name__ == "__main__":
    animal: Animal = Dog("Milo")
    print(animal.speak())
