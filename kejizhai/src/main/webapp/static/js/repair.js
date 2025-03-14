document.addEventListener('DOMContentLoaded', () => {
    const repairForm = document.getElementById('repairForm');

    repairForm.addEventListener('submit', (event) => {
        event.preventDefault();
        
        // 获取表单数据
        const formData = new FormData(repairForm);

        // 这里可以添加将表单数据发送到服务器的代码
        // 例如使用 fetch API:
        // fetch('/submit-repair', {
        //     method: 'POST',
        //     body: formData
        // }).then(response => {
        //     if (response.ok) {
        //         alert('提交成功');
        //     } else {
        //         alert('提交失败');
        //     }
        // }).catch(error => {
        //     console.error('Error:', error);
        //     alert('提交失败');
        // });

        alert('表单已提交');
    });
});