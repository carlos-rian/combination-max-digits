import itertools


def generate_combinations(max_digit: int):
    # crete list with all number
    # example: max_digit equals 6 -> [0, 1, 2, 3, 4, 5, 6]
    numbers = list(range(0, max_digit + 1))
    combinations = []
    # itertools.product create an iterator with all possible
    # combinations for list (numbers) with 4 digits
    for subset in itertools.product(numbers, repeat=4):
        # check subset sum is 21 and not equal to (0, 7, 7, 7)
        if sum(subset) == 21 and subset != (0, 7, 7, 7):
            # convert values int to str
            number_to_str = [str(x) for x in subset]
            # adds the values in the list after concatenating
            # the values and converting to int
            combinations.append(int("".join(number_to_str)))
    return combinations or None


max_digit = 4
combinations = generate_combinations(max_digit=max_digit)

print(combinations)
