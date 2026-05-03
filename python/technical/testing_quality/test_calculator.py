import sys
from pathlib import Path
import unittest

CURRENT_DIR = Path(__file__).resolve().parent
if str(CURRENT_DIR) not in sys.path:
    sys.path.insert(0, str(CURRENT_DIR))

from calculator import add


class CalculatorTests(unittest.TestCase):
    def test_add_positive_numbers(self) -> None:
        self.assertEqual(add(2, 3), 5)

    def test_add_negative_numbers(self) -> None:
        self.assertEqual(add(-1, 1), 0)


if __name__ == "__main__":
    unittest.main()
