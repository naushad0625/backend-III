<h2>Spacecraft Command System</h2>
<h3>Scenario:</h3>
<P>Design a system that handles commands sent to spacecraft. Commands differ depending on the target (rover, satellite, lander) and evolve with mission types. Some commands are timed, others are immediate. All commands must be logged, validated, and simulated before execution.</P>
<h3>Question:</h3>
<ul>
<li>What are your abstractions for "command", "target", and "execution"?</li>
<li>How do you ensure new spacecraft types can be added without modifying the system?</li>
<li>How do you isolate logging and validation?</li>
<li>What interfaces would you create?</li>
</ul>
<h3>Answer:</h3>
<table>
    <tr>
        <th>SN</th>
        <th>Question Demand</th>
        <th>Answer</th>
    </tr>
        <td>1</td>
        <td>Abstractions (Command <strong>---></strong> target <strong>---></strong> execution)</td>
        <td>Command Interface <strong>---></strong> Concrete Class for each command <strong>---></strong> execute method </td>
    <tr>
    </tr>
        <td>2</td>
        <td>Adding new sapcecraft</td>
        <td>using a spacecraft factory</td>
    <tr>
    </tr>
        <td>3</td>
        <td>isolate logging and validation</td>
        <td>using composition of logger and validator in concrete command class </td>
    <tr>
    </tr>
        <td>4</td>
        <td>interfaces</td>
        <td>ICommand, ISpacecraft</td>
    <tr>

</table>
<br/>