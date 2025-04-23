<h2>Logistics Delivery Routing System</h2>

<h3>Scenario:</h3>
<P>Design a system that calculates delivery routes. Different 
delivery types (express, standard, refrigerated) have different 
constraints. Constraints may be added dynamically (e.g., "avoid 
toll roads", "skip construction zones"). Multiple algorithms 
(Dijkstra, A*, Genetic) are used based on cost/need.</p>

<h3>Question:</h3>
<ul>
    <li>How do you abstract route generation and constraints?</li>
    <li>How would you structure the constraint system so it’s extensible at runtime?</li>
    <li>How do you plug in new algorithms without modifying existing code?</li>
</ul>

<h3>Answer:</h3>
<table>
    <tr>
        <th>SN</th>
        <th>Question Demand</th>
        <th>Answer</th>
    </tr>
        <td>1</td>
        <td>Abstracting route generation and constraints</td>
        <td>Using two different interfaces.</td>
    <tr>
    </tr>
        <td>2</td>
        <td>Structuring the constraint system </td>
        <td>Maintaining a <strong>List</strong> in each delivery type.</td>
    <tr>
    </tr>
        <td>3</td>
        <td>Plugging in new algorithms </td>
        <td>By using <strong>IRouteCalculatorStrategy</strong> interface.</td>
    <tr>

</table>
