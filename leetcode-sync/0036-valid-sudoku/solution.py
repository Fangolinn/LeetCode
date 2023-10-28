class Solution:
    def isValidSudoku(self, board: list[list[str]]) -> bool:
        for row in board:
            row_int = [int(item) for item in row if item != "."]
            if len(set(row_int)) < len(row_int):
                return False
            
        for column_no in range(9):
            column_int = []
            for row_no in range(9):
                item = board[row_no][column_no]
                if item == ".":
                    continue

                column_int.append(int(item))

            if len(set(column_int)) < len(column_int):
                return False
            
        for start_row in range(0, 9, 3):
            for start_column in range(0, 9, 3):
                board_section_int = []
                for x_coord in range(start_row, start_row + 3):
                    for y_coord in range(start_column, start_column + 3):
                        item = board[x_coord][y_coord]
                        if item == ".":
                            continue

                        board_section_int.append(int(item))

                if len(set(board_section_int)) < len(board_section_int):
                    return False
                
        return True

        
