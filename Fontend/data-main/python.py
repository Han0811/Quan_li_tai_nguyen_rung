from flask import Flask, jsonify, send_file
import json

app = Flask(__name__)

@app.route('/api/generate-json', methods=['GET'])
def generate_json():
    # Dữ liệu mẫu
    data = {
        "users": [
            {"id": 1, "name": "Alice", "email": "alice@example.com"},
            {"id": 2, "name": "Bob", "email": "bob@example.com"},
            {"id": 3, "name": "Charlie", "email": "charlie@example.com"}
        ]
    }
    
    # Ghi dữ liệu vào tệp JSON
    with open('users.json', 'w') as f:
        json.dump(data, f)
    
    # Xác nhận việc tạo file JSON
    return jsonify({"message": "File 'users.json' created successfully!"})

if __name__ == '__main__':
    app.run(debug=True)
