from flask import Flask, jsonify, send_file
import json

app = Flask(__name__)

@app.route('/api/get-json', methods=['GET'])
def get_json():
    # Dữ liệu mẫu
    data = {
        "users": [
            {"id": 1, "name": "Alice", "email": "alice@example.com"},
            {"id": 2, "name": "Bob", "email": "bob@example.com"},
            {"id": 3, "name": "Charlie", "email": "charlie@example.com"}
        ]
    }
    
    # Lưu dữ liệu vào file JSON
    with open('users.json', 'w') as f:
        json.dump(data, f)
    
    # Trả file JSON về client
    return send_file('users.json', as_attachment=False)

if __name__ == '__main__':
    app.run(debug=True)
