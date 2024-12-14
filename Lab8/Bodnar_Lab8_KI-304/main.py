import math
import struct


def calculate(x):
    try:
        return math.sin(x) / math.cos(x)
    except ZeroDivisionError:
        print("Помилка: ділення на нуль у функції `calculate`.")
        return None


def write_to_text_file(filename, data):
    try:
        with open(filename, 'w') as file:
            for x, y in data:
                file.write(f"x: {x}, y: {y}\n")
    except IOError as e:
        print(f"Помилка запису у текстовий файл '{filename}': {e}")


def write_to_binary_file(filename, data):
    try:
        with open(filename, 'wb') as file:
            for x, y in data:
                file.write(struct.pack("dd", x, y))  # 'dd' означає два double
    except IOError as e:
        print(f"Помилка запису у двійковий файл '{filename}': {e}")


def read_from_text_file(filename):
    try:
        with open(filename, 'r') as file:
            return file.readlines()
    except IOError as e:
        print(f"Помилка читання з текстового файлу '{filename}': {e}")
        return []


def read_from_binary_file(filename):
    data = []
    try:
        with open(filename, 'rb') as f:
            while True:
                bytes_read = f.read(16)  # 2 double (8 байт кожен)
                if not bytes_read:
                    break
                x, y = struct.unpack('dd', bytes_read)
                data.append((x, y))
    except IOError as e:
        print(f"Помилка читання з двійкового файлу '{filename}': {e}")
    except struct.error as e:
        print(f"Помилка розпаковування даних з двійкового файлу '{filename}': {e}")
    return data


def main():
    data = []

    try:
        x = int(input("Введіть значення x: "))
    except ValueError:
        print("Помилка: введено неціле число.")
        return

    y = calculate(x)
    if y is not None:
        data.append((x, y))

        # Записуємо результати у файли
        write_to_text_file('results.txt', data)
        write_to_binary_file('results.bin', data)

        # Читаємо дані з файлів (для перевірки)
        print("Текстові дані:")
        print(read_from_text_file('results.txt'))

        print("\nДвійкові дані:")
        print(read_from_binary_file('results.bin'))
    else:
        print("Розрахунок не виконано через помилку.")


if __name__ == "__main__":
    main()
