class ScoreBoard:
    def __init__(self, *scores: int) -> None:
        self._scores = list(scores)

    def __iter__(self):
        return iter(self._scores)

    def __len__(self) -> int:
        return len(self._scores)

    def __repr__(self) -> str:
        return f"ScoreBoard(scores={self._scores!r})"


if __name__ == "__main__":
    board = ScoreBoard(10, 20, 30)
    print(board)
    print("count =", len(board))
    print("total =", sum(board))
