from flask import Flask, jsonify
import json
import os

app = Flask(__name__)

# Biến đếm số lần gọi API
call_count = 0

@app.route('/api/generate-json', methods=['GET'])
def generate_json():
    global call_count
    # Xóa tệp nếu tồn tại
    if os.path.exists('users.json'):
        os.remove('users.json')
    
    # Dữ liệu khác nhau cho từng lần gọi
    data_options = [
        {
            "users": [
                {"id": 1, "name": "Alice", "email": "alice@example.com"}
            ]
        },
        {
            "users": [
                {"id": 2, "name": "Bob", "email": "bob@example.com"}
            ]
        },
        {
            "users": [
                {"id": 3, "name": "Charlie", "email": "charlie@example.com"}
            ]
        }
    ]
    
    # Lấy dữ liệu tương ứng dựa vào số lần gọi
    data = data_options[call_count % len(data_options)]
    
    # Cập nhật số lần gọi
    call_count += 1
    
    # Ghi dữ liệu vào tệp JSON
    with open('users.json', 'w') as f:
        json.dump(data, f)
    
    # In thông báo xác nhận
    print(f"Updated {call_count} - Data: {data}")

    # Xác nhận việc tạo file JSON
    return jsonify({"message": "File 'users.json' created successfully!", "data": data})

@app.route('/api/generate1-json', methods=['GET'])
def generate_json1():
    # Xóa tệp nếu tồn tại
    if os.path.exists('users.json'):
        os.remove('users.json')
        return jsonify({"message": "File 'users.json' deleted successfully!"})
    else:
        return jsonify({"error": "File 'users.json' does not exist."}), 404

if __name__ == '__main__':
    app.run(debug=True)
