import platform
import sys


if __name__ == "__main__":
    print("python =", sys.version.split()[0])
    print("executable =", sys.executable)
    print("platform =", platform.platform())
