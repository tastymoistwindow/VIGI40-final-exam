import { getPlayers, deletePlayerById } from "../../requests/requests.js";

const renderPlayerListTableRows = async (players) => {
    const playerTable = document.getElementById("playerListTable")
    const playerTableBody = playerTable.querySelector("tbody")
    players.forEach((p) => {
        const playerTableRow = document.createElement("tr")

        const nameCell = document.createElement("td")
        nameCell.innerText = p.name
        playerTableRow.appendChild(nameCell)

        const lastNameCell = document.createElement("td")
        lastNameCell.innerText = p.lastName
        playerTableRow.appendChild(lastNameCell)

        const emailCell = document.createElement("td")
        emailCell.innerText = p.email
        playerTableRow.appendChild(emailCell)

        const sexCell = document.createElement("td")
        sexCell.innerText = p.sex
        playerTableRow.appendChild(sexCell)

        const ageCell = document.createElement("td")
        ageCell.innerText = p.age
        playerTableRow.appendChild(ageCell)

        const playerExperienceCell = document.createElement("td")
        playerExperienceCell.innerText = p.playerExperience
        playerTableRow.appendChild(playerExperienceCell)

        const actionsCell = document.createElement("td")

        const btnGroupDiv = document.createElement("div")

        const editBtn = document.createElement("button")
        editBtn.innerHTML = "Edit player"
        btnGroupDiv.className = "btn-group"
        editBtn.setAttribute("id", "editBtn")
        editBtn.className = "btn btn-outline-primary"
        editBtn.addEventListener("click", async () => {
            window.location.replace(`../edit-player/edit-player.html?id=${p.id}`)
        })
        btnGroupDiv.appendChild(editBtn)

        const deleteBtn = document.createElement("button")
        deleteBtn.innerText = "Delete player"
        deleteBtn.className = "btn btn-outline-primary"
        deleteBtn.setAttribute("id", "deleteBtn")
        deleteBtn.addEventListener("click", async () => {
            await deletePlayerById(p.id)
            window.location.reload()
        })
        btnGroupDiv.appendChild(deleteBtn)

        actionsCell.appendChild(btnGroupDiv)

        playerTableRow.appendChild(actionsCell)

        playerTableBody.appendChild(playerTableRow)
    });
}


(async () => {
    const player = await getPlayers()
    renderPlayerListTableRows(player)
})()



