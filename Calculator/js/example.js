document.addEventListener('DOMContentLoaded', () => {

    const addForm = document.querySelector('.name-add'),
        addInput = addForm.querySelector('.adding-input-name'),
        itemInput = addForm.querySelector('.adding-input-item'),
        btn = addForm.querySelector('.name-button'),
        calcForm = document.querySelector('.calc-add'),
        calcBtn = calcForm.querySelector('.add-button'),
        calcInput = calcForm.getElementsByClassName('adding-input-calc'),
        costInput = calcForm.getElementsByClassName('adding-input-cost'),
        totalForm = document.querySelector('.total'),
        totalCost = totalForm.querySelector('.sum'),
        total_one = totalForm.querySelector('.total_one'),
        getBtn = document.querySelector('.get-by-name'),
        saveBtn = document.querySelector('.save-all'),
        deleteBtn = document.querySelector('.delete'),
        getNameInput = document.querySelector('.take-name-input'),
        getIpInput = document.querySelector('.take-id-input'),
        b1 = document.getElementsByClassName('del-btn'),
        col = document.getElementsByClassName('col'),
        addTrBtn = document.querySelector('.add-tr'),
        tBody = document.querySelector('.tbody'),
        tBodyPp = document.querySelector('.tbody-2'),
        getAllBtn = document.querySelector('.get-all'),
        ppName = document.getElementsByClassName('take-name-input-1'),
        ppID = document.getElementsByClassName('take-id-input-1');


        addTrBtn.addEventListener('click', function (event) {
            event.preventDefault();
                let newTr = document.createElement('tr');
                newTr.className = 'col';
                newTr.innerHTML =
                    '<tr style="height: 19pt">\n' +
                    '<td class="e1" style="height: 19pt">\n' +
                    '<input class="adding-input-calc" type="text" pattern="^[А-Яа-яЁё\\s]+$" placeholder="">\n' +
                    '</td>\n' +
                    '<td class="e2" style="height: 19pt">\n' +
                    '<input class="adding-input-cost" type="number" placeholder="0">\n' +
                    '</td>\n' +
                    '<td class="b1" style="height: 19pt">\n' +
                    '<button class="del-btn">X</button>\n' +
                    '</td>' +
                    '</tr>'
                tBody.appendChild(newTr);
                if (tBody.childElementCount > 12) {
                    alert('Больше добавить нельзя')
                    tBody.removeChild(newTr)
                }
        });

    getAllBtn.addEventListener('click', function (event) {
        event.preventDefault();
        let objAll = fetch('http://localhost:8080/expenses/getAll')
            .then((response) => response.json())
            .then((objAllData) => {
                let { name, number, totalSum, materialList, expensesId } = objAllData;
                let i = 0; while (i < objAllData.length) {
                    let newTrr = document.createElement('tr');
                    newTrr.className = 'col-pp';
                    newTrr.innerHTML =
                        '<tr style="height: 19pt">\n' +
                        '<td class="e-p1" style="height: 19pt">\n' +
                        '<input class="take-name-input-1" readonly>\n' +
                        '</td>\n' +
                        '<td class="e-p2" style="height: 19pt">\n' +
                        '<input class="take-id-input-1" readonly>\n' +
                        '</td>\n' +
                        '</tr>'
                    tBodyPp.appendChild(newTrr);
                    ppName[i].value = objAllData[i].name;
                    ppID[i].value = objAllData[i].expensesId;
                    console.log(objAllData)
                    i++;
                    if (tBodyPp.childElementCount > 16)
                    {
                        tBodyPp.removeChild(newTrr)
                    }
                    if ((ppName[i].value != null || undefined)
                    && (ppID[i].value != null || undefined)) {
                        tBodyPp.removeChild(newTrr)
                    }
                }
            });
    });

    getBtn.addEventListener('click', function (event) {
        event.preventDefault();
        let obj = fetch(`http://localhost:8080/expenses?name=${getNameInput.value}`)
            .then((response) => response.json())
            .then((objData) => {
                let { name, number, totalSum, materialList } = objData;

                addInput.value = name;
                itemInput.value = number;
                totalCost.value = totalSum;
                for (let i = 0; i <= calcInput.length; i++) {
                    calcInput[i].value = materialList[i].name;
                    costInput[i].value = materialList[i].price;
                }
            });

    });

    saveBtn.addEventListener('click', function (event) {
        event.preventDefault();
        let saveObj = fetch('http://localhost:8080/expenses',
            {method: 'POST', body:JSON.stringify({
                    name: addInput.value,
                    number: itemInput.value,
                    totalSum : totalCost.value,
                    materialList:
                            [{name: calcInput[0].value, price: costInput[0].value},
                            {name: calcInput[1].value, price: costInput[1].value},
                            {name: calcInput[2].value, price: costInput[2].value},
                            {name: calcInput[3].value, price: costInput[3].value},
                            {name: calcInput[4].value, price: costInput[4].value}
                            || {name: calcInput[5].value, price: costInput[5].value}
                            || {name: calcInput[6].value, price: costInput[6].value}
                            || {name: calcInput[7].value, price: costInput[7].value}
                            || {name: calcInput[8].value, price: costInput[8].value}
                            || {name: calcInput[9].value, price: costInput[9].value}
                            || {name: calcInput[10].value, price: costInput[10].value}]
                }), headers:{'content-type': 'application/json'}})
    });

    deleteBtn.addEventListener('click', function (event) {
        event.preventDefault();

        let delObj = fetch(`http://localhost:8080/expenses?expenses_id=${getIpInput.value}`,
            {method: 'DELETE'});
    });

    addForm.addEventListener('submit', function (ev) {
        ev.preventDefault();

        let newProduct = addInput.value,
            newCount = itemInput.value;

        let sum = 0;

        if (newProduct != null && typeof newProduct != 'undefined' && newCount != null && typeof newCount !="undefined") {
            newProduct = newProduct.trim();
            newCount = newCount.trim();
        }

        if (!newProduct || !newCount) {
            alert('Вы не ввели количество или название продукта')
        } else {
            function func() {
                for (let i = 0; i < costInput.length; i++) {
                    sum += +costInput[i].value;
                }
            }

            func();

            let total = (sum/newCount).toFixed(2);

            totalCost.value = sum;
            total_one.value = total;

        }
  });

   function del() {
        for (let i = 0; i <= tBody.childElementCount; i++) {
            b1[i].addEventListener('click', function (event) {
                event.preventDefault();
                tBody.removeChild(col[i]);
            });
        }
    }
    del();
});